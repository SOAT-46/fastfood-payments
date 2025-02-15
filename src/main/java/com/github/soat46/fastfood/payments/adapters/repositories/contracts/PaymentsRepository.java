package com.github.soat46.fastfood.payments.adapters.repositories.contracts;

import com.github.soat46.fastfood.payments.adapters.repositories.models.MongoPayment;

import java.util.Optional;

public interface PaymentsRepository {

    MongoPayment save(MongoPayment mongoPayment);
    Optional<MongoPayment> findById(String id);
}
