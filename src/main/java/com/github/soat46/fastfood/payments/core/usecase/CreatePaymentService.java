package com.github.soat46.fastfood.payments.core.usecase;

import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.CreatePaymentPort;
import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.MercadoPagoIntegrationPort;
import com.github.soat46.fastfood.payments.adapters.repositories.MongoPaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.MongoPayment;
import com.github.soat46.fastfood.payments.controller.dto.WebhookDto;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.github.soat46.fastfood.payments.core.usecase.interfaces.CreatePaymentUseCase;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CreatePaymentService implements CreatePaymentUseCase {

    private final MercadoPagoIntegrationPort mercadoPagoPort;
    private final CreatePaymentPort createPayment;
    private final PaymentClient paymentClient;
    private final MongoPaymentsRepository paymentsRepository;

    public CreatePaymentService(
        final MercadoPagoIntegrationPort mercadoPort,
        final CreatePaymentPort paymentPort, 
        final PaymentClient client,
        final MongoPaymentsRepository repository) {
        mercadoPagoPort = mercadoPort;
        createPayment = paymentPort;
        paymentClient = client;
        paymentsRepository = repository;
    }

    @Override
    public Optional<FastfoodPayment> create(final PaymentNotification input) {
        final var payment = mercadoPagoPort.create(input);
        if (payment.isPresent()) {
          return createPayment.create(payment.get());
        }
        return Optional.empty();
    }

    @Override
    public boolean webhook(WebhookDto webhookDto) throws MPException, MPApiException {
        if(webhookDto.action().equals("payment.updated")) {
            //  final var mercadoPayment = paymentClient.get(webhookDto.data().id());
            //  final MongoPayment payment = MongoPayment.from(mercadoPayment);
             final MongoPayment payment = null;
            paymentsRepository.create(payment);
            return true;
        }
        return false;
    }
}
