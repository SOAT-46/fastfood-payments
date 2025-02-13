package com.github.soat46.fastfood.payments.core.usecase.interfaces;

import com.github.soat46.fastfood.payments.controller.dto.WebhookDto;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;

import java.util.Optional;

public interface CreatePaymentUseCase {

    Optional<FastfoodPayment> create(PaymentNotification input);
    boolean webhookHandle(WebhookDto webhookDto) throws MPException, MPApiException;

}
