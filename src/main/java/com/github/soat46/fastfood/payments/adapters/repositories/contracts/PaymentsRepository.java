package com.github.soat46.fastfood.payments.adapters.repositories.contracts;

import com.github.soat46.fastfood.payments.adapters.repositories.models.Payment;

import java.util.Optional;

public interface PaymentsRepository {

    Payment save(Payment payment);
    Optional<Payment> findById(String id);
}
