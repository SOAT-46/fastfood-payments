package com.github.soat46.fastfood.payments.adapters.gateways;

import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.GetPaymentPort;
import com.github.soat46.fastfood.payments.adapters.repositories.contracts.PaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.MongoPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class GetPaymentAdapter implements GetPaymentPort {
    private final PaymentsRepository repository;

    public GetPaymentAdapter(final PaymentsRepository paymentsRepository) {
        repository = paymentsRepository;
    }

    @Override
    public Optional<FastfoodPayment> get(final String paymentId) {
        try {
            final var payment = repository.findById(paymentId);
            return payment.map(MongoPayment::toDomain);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Optional.empty();
        }
    }
}
