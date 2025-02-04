package com.github.soat46.fastfood.payments.adapters.gateways;

import com.github.soat46.fastfood.payments.adapters.repositories.doubles.DummyMongoPaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.doubles.InMemoryMongoPaymentsRepository;
import com.github.soat46.fastfood.payments.core.entities.builders.FastfoodPaymentBuilder;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
@NoArgsConstructor
class CreatePaymentAdapterTest {

    @Test
    @VisibleForTesting
    @DisplayName("should save the payment successfully")
    void onSuccess() {
        // given
        final var payment = new FastfoodPaymentBuilder().build();
        final var repository = new InMemoryMongoPaymentsRepository();
        final var adapter = new CreatePaymentAdapter(repository);

        // when
        final var response = adapter.create(payment);

        // then
        assertNotNull(response, "the response should not be null");
    }

    @Test
    @VisibleForTesting
    @DisplayName("should return empty when the payment fails")
    void onError() {
        // given
        final var payment = new FastfoodPaymentBuilder().build();
        final var repository = new DummyMongoPaymentsRepository();
        final var adapter = new CreatePaymentAdapter(repository);

        // when
        final var response = adapter.create(payment);

        // then
        assertNotNull(response, "the response should not be null");
    }
}