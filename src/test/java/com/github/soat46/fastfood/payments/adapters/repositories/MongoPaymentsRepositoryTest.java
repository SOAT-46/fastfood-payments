package com.github.soat46.fastfood.payments.adapters.repositories;

import com.github.soat46.fastfood.payments.adapters.repositories.contracts.PaymentsRepository;
import com.github.soat46.fastfood.payments.adapters.repositories.models.MongoPayment;
import org.junit.jupiter.api.*;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.testcontainers.containers.MongoDBContainer;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
@Tag("integration")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MongoPaymentsRepositoryTest {

    private final PaymentsRepository repository;
    protected static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:latest");

    @Autowired
    public MongoPaymentsRepositoryTest(final PaymentsRepository mongoPaymentsRepository) {
        repository = mongoPaymentsRepository;
    }

    @BeforeAll
    void setupContainers() {
        mongoDBContainer.start();
        System.setProperty("spring.data.mongodb.uri", mongoDBContainer.getReplicaSetUrl());
    }

    @AfterAll
    void tearDownContainers() {
        mongoDBContainer.stop();
    }

    @Test
    @VisibleForTesting
    @DisplayName("should save the payment successfully")
    void onSave() {
        // given
        final var payment = MongoPayment.builder().build();

        // when
        final var response = repository.create(payment);

        // then
        assertNotNull(response,  "Payment should not be null");
    }
}
