package com.github.soat46.fastfood.payments.adapters.gateways;

import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.MercadoPagoIntegrationPort;
import com.github.soat46.fastfood.payments.core.entities.OrderSnack;
import com.github.soat46.fastfood.payments.core.entities.mercadopago.QRCodeData;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.OrderSnackPaymentStatus;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.github.soat46.fastfood.shared.MercadoPagoSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class MercadoPagoIntegrationAdapter implements MercadoPagoIntegrationPort {

  private static final String PAYMENT_METHOD_PIX = "pix";
  private static final String PAYMENT_DESCRIPTION = "PIX";
  private static final int PAYMENT_INSTALLMENTS = 1;

  private final MercadoPagoSettings settings;

  public MercadoPagoIntegrationAdapter(final MercadoPagoSettings mercadoPagoSettings) {
    settings = mercadoPagoSettings;
  }

  @Override
  public Optional<FastfoodPayment> create(final PaymentNotification input) {
    //        try {
    //            final var payer = PaymentPayerRequest.builder()
    //                .email(input.getEmail())
    //                .build();
    //            final var createRequest = PaymentCreateRequest.builder()
    //                .transactionAmount(input.getAmount())
    //                .installments(PAYMENT_INSTALLMENTS)
    //                .paymentMethodId(PAYMENT_METHOD_PIX)
    //                .description(PAYMENT_DESCRIPTION)
    //                .payer(payer)
    //                .build();
    //
    //        final var payment = client.create(createRequest);
    //        return Optional.of(FastfoodPayment.builder().build());
    //        } catch (Exception e) {
    //            return Optional.empty();
    //        }
    return Optional.empty();
  }

  @Override
  public QRCodeData requestQrData(final OrderSnack order, final UUID externalReference) {
    //        final var mercadoPagoOrder = convert(order, externalReference);
    //        try {
    //            log.info("Requesting QRCode data to MercadoPago with order: " +
    // objectMapper.writeValueAsString(mercadoPagoOrder));
    //            final var response = restTemplate.postForEntity(
    //                    settings.getQRCodeURL(), mercadoPagoOrder, QRCodeData.class);
    //            log.info("response: " + objectMapper.writeValueAsString(response.getBody()));
    //
    //            return Objects.requireNonNull(response.getBody());
    //        } catch (Exception ex){
    //            log.info("Error requesting QRCode data to MercadoPago: " + ex.getMessage());
    //            throw new RuntimeException(ex.getMessage());
    //        }
    return null;
  }

  @Override
  public Optional<OrderSnackPaymentStatus> getOrderData(final String paymentId) {
    String fullUrl = settings.getOrderURL(paymentId);
    //        try {
    //            log.info("Requesting order data to MercadoPago with paymentId: " + paymentId);
    //
    //            final var response = restTemplate.getForEntity(fullUrl,
    // MercadoPagoOrderData.class);
    //            final var mercadoPagoOrderData = Objects.requireNonNull(response.getBody());
    //            log.info("response: " + objectMapper.writeValueAsString(mercadoPagoOrderData));
    //
    //            return new OrderSnackPaymentStatus(
    //                    UUID.fromString(mercadoPagoOrderData.getExternalReference()),
    //                    mercadoPagoOrderData.getStatus());
    //        } catch (Exception ex) {
    //            log.info("Error requesting order data to MercadoPago: {}", ex.getMessage());
    //            throw new RuntimeException(ex.getMessage());
    //        }
    return Optional.empty();
  }

  //    public MercadoPagoOrder convert(
  //            final OrderSnack orderSnack, final UUID externalReference) {
  //        final var mercadoPagoOrder = new MercadoPagoOrder();
  //        mercadoPagoOrder.setDescription(PAYMENT_DESCRIPTION);
  //        mercadoPagoOrder.setTitle(PAYMENT_DESCRIPTION);
  //        mercadoPagoOrder.setExternalReference(String.valueOf(externalReference));
  //        mercadoPagoOrder.setTotalAmount(orderSnack.getTotalPrice());
  //        mercadoPagoOrder.setNotificationUrl(settings.getNotificationUrl());
  //
  //        mercadoPagoOrder.setItems(orderSnack.getItems().stream()
  //                .map(item -> new MercadoPagoItem(
  //                        item.getProduct().getProductId().toString(),
  //                        item.getProduct().getPrice(),
  //                        item.getQuantity(),
  //                        "unit",
  //
  // item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
  //                ))
  //                .collect(Collectors.toList()));
  //
  //        return mercadoPagoOrder;
  //    }
}
