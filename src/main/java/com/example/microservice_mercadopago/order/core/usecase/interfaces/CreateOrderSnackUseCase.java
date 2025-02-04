package com.example.microservice_mercadopago.order.core.usecase.interfaces;

import com.example.microservice_mercadopago.order.controller.DTO.OrderSnackRequest;

public interface CreateOrderSnackUseCase {
    byte[] requestOrder(OrderSnackRequest orderSnackRequest);

}
