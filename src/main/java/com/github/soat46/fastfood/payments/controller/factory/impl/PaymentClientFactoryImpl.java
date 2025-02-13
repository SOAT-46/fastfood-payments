package com.github.soat46.fastfood.payments.controller.factory.impl;

import com.mercadopago.client.payment.PaymentClient;

public interface PaymentClientFactoryImpl {
    public PaymentClient createPaymentClient();
}
