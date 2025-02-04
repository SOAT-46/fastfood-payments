package com.example.microservice_mercadopago.order.core.entities.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentNotification {
    @JsonProperty("data")
    private PaymentNotificationData data;
}