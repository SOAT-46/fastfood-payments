package com.github.soat46.fastfood.payments.core.entities;

import jakarta.validation.constraints.Min;
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
