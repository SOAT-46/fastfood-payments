package com.github.soat46.fastfood.payments.controller;

import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.usecase.interfaces.GetPaymentUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payments")
@Tag(name = "payments", description = "Payments")
public final class GetPaymentController {
  public final GetPaymentUseCase useCase;

  public GetPaymentController(final GetPaymentUseCase paymentUseCase) {
    useCase = paymentUseCase;
  }

  @GetMapping("{paymentId}")
  @Operation(summary = "Get the payment detailed information", description = "Get the payment detailed information")
  public ResponseEntity<FastfoodPayment> get(@PathVariable String paymentId) {
    final var found = useCase.get(paymentId);
    if (found.isPresent()) {
      final var payment = found.get();
      return ResponseEntity.ok(payment);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
