package com.github.soat46.fastfood.payments.core.entities.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class OrderSnackPaymentStatus {
  public UUID externalOrderId;
  public String paymentStatus;
}
