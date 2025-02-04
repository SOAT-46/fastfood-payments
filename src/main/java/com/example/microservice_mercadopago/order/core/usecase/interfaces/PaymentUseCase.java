package com.example.microservice_mercadopago.order.core.usecase.interfaces;

import com.example.microservice_mercadopago.order.core.entities.payment.PaymentNotification;

public interface PaymentUseCase {
    void updatePaymentStatus(PaymentNotification notification);
}