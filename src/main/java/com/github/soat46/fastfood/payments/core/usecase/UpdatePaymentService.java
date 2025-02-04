package com.github.soat46.fastfood.payments.core.usecase;

import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.MercadoPagoIntegrationPort;
import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.OrderPort;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.github.soat46.fastfood.payments.core.usecase.interfaces.UpdatePaymentUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UpdatePaymentService implements UpdatePaymentUseCase {

  private final MercadoPagoIntegrationPort mercadoPagoPort;
  private final OrderPort orderPort;

  public UpdatePaymentService(final MercadoPagoIntegrationPort mercadoPort, final OrderPort order) {
    mercadoPagoPort = mercadoPort;
    orderPort = order;
  }

  @Override
  public void updateStatus(final PaymentNotification notification) {
    try {
      log.info("Updating payment status for order: {}", notification.getData().getId());
      final var orderData = mercadoPagoPort.getOrderData(notification.getData().getId());
      if (orderData.isEmpty()) {
        return;
      }

      final var orderId = String.valueOf(orderData.get().getExternalOrderId());
      final var foundOrder = orderPort.getById(orderId);
      foundOrder.ifPresent(
          order -> {
            order.updatePaymentStatus(orderData.get());
            order.updateStatus();
            log.info("Payment status updated to: {}", order.getPaymentProgress());

            orderPort.update(order);
            log.info("Payment status updated successfully");
          });
    } catch (Exception e) {
      log.error("Error updating payment status: {}", e.getMessage());
      throw new RuntimeException("Error updating payment status: " + e.getMessage());
    }
  }
}
