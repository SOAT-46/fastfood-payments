package com.github.soat46.fastfood.payments.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.github.soat46.fastfood.payments.core.usecase.UpdatePaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/payments/webhook")
@Tag(name = "payments", description = "Payments")
public final class UpdatePaymentController {

  private final ObjectMapper mapper = new ObjectMapper();
  private final UpdatePaymentService useCase;

  public UpdatePaymentController(final UpdatePaymentService paymentService) {
    useCase = paymentService;
  }

  @PatchMapping
  @Operation(summary = "Update the payment", description = "Update the payment")
  public ResponseEntity<FastfoodPayment> post(final @RequestBody PaymentNotification notification)
      throws JsonProcessingException {
    final var not = mapper.writeValueAsString(notification);
    if (notification.getData().getId().isBlank()) {
      log.error("ID NOT FOUND IN NOTIFICATION: {}", not);
      return ResponseEntity.notFound().build();
    }
    log.info("NEW NOTIFICATION ARRIVED: {}", not);
    useCase.updateStatus(notification);
    return ResponseEntity.ok().build();
  }
}
