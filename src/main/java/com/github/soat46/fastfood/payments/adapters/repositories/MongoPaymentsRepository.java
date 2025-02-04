package com.github.soat46.fastfood.payments.adapters.repositories;

import com.github.soat46.fastfood.payments.adapters.repositories.contracts.PaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoPaymentsRepository
    extends PaymentsRepository, MongoRepository<Payment, String> {}
