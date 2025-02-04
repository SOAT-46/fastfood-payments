package com.github.soat46.fastfood.payments.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.github.soat46.fastfood.payments.core.usecase.UpdatePaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payments/webhook")
public class UpdatePaymentController {

  private final ObjectMapper mapper = new ObjectMapper();
  private final UpdatePaymentService useCase;

  public UpdatePaymentController(final UpdatePaymentService paymentService) {
    useCase = paymentService;
  }

  @PostMapping
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
