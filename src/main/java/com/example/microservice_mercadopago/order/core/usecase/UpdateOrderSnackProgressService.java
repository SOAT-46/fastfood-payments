package com.example.microservice_mercadopago.order.core.usecase;

import com.example.microservice_mercadopago.order.adapters.repository.OrderSnackPort;
import com.example.microservice_mercadopago.order.core.entities.enums.OrderProgress;
import com.example.microservice_mercadopago.order.core.usecase.interfaces.UpdateOrderSnackProgressUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateOrderSnackProgressService implements UpdateOrderSnackProgressUseCase {

    @Autowired
    private final OrderSnackPort orderSnackPort;

    @Override
    public void updateOrderSnackProgress(OrderProgress orderProgress, UUID orderSnackId) {
        orderSnackPort.updateOrderSnackProgress(orderProgress, orderSnackId);
    }

}
