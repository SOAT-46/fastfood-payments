package com.example.microservice_mercadopago.order.core.usecase;

import com.example.microservice_mercadopago.order.adapters.repository.OrderSnackPort;
import com.example.microservice_mercadopago.order.core.entities.enums.OrderProgress;
import com.example.microservice_mercadopago.order.core.usecase.interfaces.GetOrderSnackProgressUseCase;
import com.example.microservice_mercadopago.order.utils.OrderProgressMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GetOrderSnackProgressService implements GetOrderSnackProgressUseCase {

    @Autowired
    private final OrderSnackPort orderSnackPort;

    @Override
    public OrderProgress getOrderSnackProgress(UUID orderSnackId) {
        return orderSnackPort.getOrderSnackProgress(orderSnackId);
    }

}
