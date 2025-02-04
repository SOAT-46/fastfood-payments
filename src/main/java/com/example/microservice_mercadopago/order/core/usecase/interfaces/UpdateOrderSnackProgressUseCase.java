package com.example.microservice_mercadopago.order.core.usecase.interfaces;

import com.example.microservice_mercadopago.order.core.entities.enums.OrderProgress;

import java.util.UUID;

public interface UpdateOrderSnackProgressUseCase {
    void updateOrderSnackProgress (OrderProgress orderProgress, UUID orderSnackId);
}
