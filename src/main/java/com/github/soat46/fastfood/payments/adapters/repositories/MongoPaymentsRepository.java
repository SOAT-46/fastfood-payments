package com.github.soat46.fastfood.payments.adapters.repositories;

import com.github.soat46.fastfood.payments.adapters.repositories.contracts.PaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.MongoPayment;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoPaymentsRepository
    extends PaymentsRepository, MongoRepository<MongoPayment, String> {

    @Override
    default MongoPayment create(final MongoPayment payment) {
        return this.save(payment);
    }
}
