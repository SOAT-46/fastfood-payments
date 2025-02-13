package com.github.soat46.fastfood.payments.controller.factory;

import com.github.soat46.fastfood.payments.controller.factory.impl.PaymentClientFactoryImpl;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import org.springframework.stereotype.Component;

@Component
public class PaymentClientFactory implements PaymentClientFactoryImpl {

    private String token;

    private PaymentClient paymentClient;

    public PaymentClient createPaymentClient() {
        MercadoPagoConfig.setAccessToken(token);

        if(this.paymentClient == null) {
            MercadoPagoConfig.setAccessToken(token);
            this.paymentClient = new PaymentClient();
        }

        return this.paymentClient;
    }
}
