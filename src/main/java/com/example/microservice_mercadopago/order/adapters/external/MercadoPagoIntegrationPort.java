package com.example.microservice_mercadopago.order.adapters.external;


import com.example.microservice_mercadopago.order.core.entities.OrderSnack;
import com.example.microservice_mercadopago.order.core.entities.mercadopago.QRCodeData;
import com.example.microservice_mercadopago.order.core.entities.payment.OrderSnackPaymentStatus;

import java.util.UUID;

public interface MercadoPagoIntegrationPort {
    QRCodeData requestQrData(OrderSnack order, UUID externalReference);
    OrderSnackPaymentStatus getOrderData(String paymentId);
}
