package com.example.microservice_mercadopago.order.utils;

import com.example.microservice_mercadopago.order.core.entities.enums.OrderProgress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderProgressMapper {
    OrderProgress toOrderProgress(OrderProgress orderProgress);
}