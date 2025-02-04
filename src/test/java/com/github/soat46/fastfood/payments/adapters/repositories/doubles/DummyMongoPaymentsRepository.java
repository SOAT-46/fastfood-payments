package com.github.soat46.fastfood.payments.adapters.repositories.doubles;

import com.github.soat46.fastfood.payments.adapters.repositories.contracts.PaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.Payment;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public final class DummyMongoPaymentsRepository implements PaymentsRepository {

    @Override
    public Payment save(final Payment payment) {
        throw new RuntimeException("Error");
    }

    @Override
    public Optional<Payment> findById(final String id) {
        throw new RuntimeException("Error");
    }
}
