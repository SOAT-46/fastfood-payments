package com.github.soat46.fastfood.payments.adapters.gateways;

import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.GetPaymentPort;
import com.github.soat46.fastfood.payments.adapters.repositories.contracts.PaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.Payment;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetPaymentAdaptor implements GetPaymentPort {
    private final PaymentsRepository repository;

    public GetPaymentAdaptor(final PaymentsRepository paymentsRepository) {
        repository = paymentsRepository;
    }

    @Override
    public Optional<FastfoodPayment> get(final String paymentId) {
        Optional<FastfoodPayment> entity;
        final var payment = repository.findById(paymentId);
        entity = payment.map(Payment::toDomain);
        return entity;
    }
}
