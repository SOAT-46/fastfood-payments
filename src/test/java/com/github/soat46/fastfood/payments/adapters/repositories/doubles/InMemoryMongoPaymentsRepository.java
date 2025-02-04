package com.github.soat46.fastfood.payments.adapters.repositories.doubles;

import com.github.soat46.fastfood.payments.adapters.repositories.contracts.PaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.Payment;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public final class InMemoryMongoPaymentsRepository implements PaymentsRepository {

    @Override
    public Payment save(final Payment payment) {
        return payment;
    }

    @Override
    public Optional<Payment> findById(final String id) {
        return Optional.empty();
    }
}
