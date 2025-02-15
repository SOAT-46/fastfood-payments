package com.github.soat46.fastfood.payments.adapters.repositories.doubles;

import com.github.soat46.fastfood.payments.adapters.repositories.contracts.PaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.MongoPayment;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public final class InMemoryMongoPaymentsRepository implements PaymentsRepository {

    @Override
    public MongoPayment save(final MongoPayment mongoPayment) {
        return mongoPayment;
    }

    @Override
    public Optional<MongoPayment> findById(final String id) {
        return Optional.empty();
    }
}
