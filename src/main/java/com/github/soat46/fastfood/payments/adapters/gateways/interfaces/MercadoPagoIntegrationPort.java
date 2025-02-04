package com.github.soat46.fastfood.payments.adapters.gateways.interfaces;

import com.github.soat46.fastfood.payments.core.entities.OrderSnack;
import com.github.soat46.fastfood.payments.core.entities.mercadopago.QRCodeData;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.OrderSnackPaymentStatus;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;

import java.util.Optional;
import java.util.UUID;

public interface MercadoPagoIntegrationPort {

  Optional<FastfoodPayment> create(PaymentNotification input);

  QRCodeData requestQrData(OrderSnack order, UUID externalReference);

  Optional<OrderSnackPaymentStatus> getOrderData(String paymentId);
}
