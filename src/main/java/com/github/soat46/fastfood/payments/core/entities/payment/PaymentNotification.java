package com.github.soat46.fastfood.payments.core.entities.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentNotification {
  @JsonProperty("data")
  private PaymentNotificationData data;
}
