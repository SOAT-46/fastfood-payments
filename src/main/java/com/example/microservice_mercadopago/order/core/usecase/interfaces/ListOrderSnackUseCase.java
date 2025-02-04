package com.example.microservice_mercadopago.order.core.usecase.interfaces;

import com.example.microservice_mercadopago.order.core.entities.OrderSnack;
import com.example.microservice_mercadopago.order.core.entities.enums.OrderProgress;

import java.util.List;

public interface ListOrderSnackUseCase {

    public List<OrderSnack> listOrderSnack(OrderProgress progress, String cpf);

}
