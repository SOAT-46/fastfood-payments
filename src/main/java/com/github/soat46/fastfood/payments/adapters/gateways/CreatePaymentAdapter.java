package com.github.soat46.fastfood.payments.adapters.gateways;

import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.CreatePaymentPort;
import com.github.soat46.fastfood.payments.adapters.repositories.contracts.PaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.MongoPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreatePaymentAdapter implements CreatePaymentPort {
    private final PaymentsRepository repository;

    public CreatePaymentAdapter(final PaymentsRepository paymentsRepository) {
        repository = paymentsRepository;
    }

  @Override
  public Optional<FastfoodPayment> create(final FastfoodPayment fastfoodPayment) {
        try {
            final var dbEntity = MongoPayment.from(fastfoodPayment);
            final var payment = repository.save(dbEntity);
            return Optional.of(payment.toDomain());
        } catch (Exception e) {
            return Optional.empty();
        }
  }
}
