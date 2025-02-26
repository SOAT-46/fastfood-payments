package com.example.microservice_mercadopago.order.core.entities.mercadopago;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MercadoPagoCashOut {
    private BigDecimal amount;
}
