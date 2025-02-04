package com.example.microservice_mercadopago.order.core.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSnackItem {
    private UUID orderSnackItemId;

    private OrderSnack orderSnack;

    private BigDecimal amount;

    @Min(value = 1, message = "The quantity must be more than zero.")
    private Integer quantity;

}
