package com.github.soat46.fastfood.payments.adapters.gateways;

import com.github.soat46.fastfood.payments.adapters.repositories.doubles.DummyMongoPaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.doubles.InMemoryMongoPaymentsRepository;
import com.google.common.annotations.VisibleForTesting;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("unit")
@NoArgsConstructor
class GetPaymentAdapterTest {

    @Test
    @VisibleForTesting
    @DisplayName("should get the payment successfully")
    void onSuccess() {
        // given
        final var repository = new InMemoryMongoPaymentsRepository();
        final var adapter = new GetPaymentAdapter(repository);

        // when
        final var response = adapter.get("");

        // then
        assertNotNull(response,  "response should not be null");
    }

    @Test
    @VisibleForTesting
    @DisplayName("should return an empty when there's an error to get the data")
    void onError() {
        // given
        final var repository = new DummyMongoPaymentsRepository();
        final var adapter = new GetPaymentAdapter(repository);

        // when
        final var response = adapter.get("");

        // then
        assertTrue(response.isEmpty(),  "response should not be empty");
    }
}