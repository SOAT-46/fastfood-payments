package com.github.soat46.fastfood.payments.core.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.soat46.fastfood.payments.core.entities.enums.OrderProgress;
import com.github.soat46.fastfood.payments.core.entities.enums.PaymentProgress;
import com.github.soat46.fastfood.payments.core.entities.payment.OrderSnackPaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSnack {

  private UUID orderSnackId;
  private OrderProgress progress = OrderProgress.RECEIVED;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
  private LocalDateTime createdAt = LocalDateTime.now();

  private PaymentProgress paymentProgress = PaymentProgress.OPENED;
  private String externalOrderId;
  private String customer;
  private List<OrderSnackItem> items;

  @JsonIgnore private BigDecimal totalPrice;

  public void setItems(final List<OrderSnackItem> items) {
    this.items = items;
    this.totalPrice = calculateItems(items);
  }

  private BigDecimal calculateItems(List<OrderSnackItem> items) {
    BigDecimal totalPrice = BigDecimal.ZERO;
    if (items != null) {
      for (OrderSnackItem item : items) {
        BigDecimal itemTotal = item.getAmount();
        totalPrice = totalPrice.add(itemTotal);
      }
    }
    return totalPrice;
  }

  public void updatePaymentStatus(final OrderSnackPaymentStatus paymentStatus) {
    final var oldStatus = paymentStatus.getPaymentStatus();
    paymentProgress =
        switch (oldStatus) {
          case "approved" -> PaymentProgress.APPROVED;
          case "opened" -> PaymentProgress.OPENED;
          case "expired" -> PaymentProgress.EXPIRED;
          default ->
              throw new UnsupportedOperationException(
                  "Payment status"
                      + oldStatus
                      + " not supported, choose between: closed, opened or expired");
        };
  }

  public void updateStatus() {
    OrderProgress progress;
    if (paymentProgress.equals(PaymentProgress.APPROVED)) {
      progress = OrderProgress.IN_PREPARATION;
    } else {
      progress = OrderProgress.RECEIVED;
    }
    this.progress = progress;
  }
}
