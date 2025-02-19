package com.github.soat46.fastfood.payments.controller;

import com.github.soat46.fastfood.payments.controller.dto.WebhookDto;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.github.soat46.fastfood.payments.core.usecase.interfaces.CreatePaymentUseCase;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping("/payments")
@Tag(name = "payments", description = "Payments")
public final class CreatePaymentController {
    private final CreatePaymentUseCase useCase;

    public CreatePaymentController(final CreatePaymentUseCase paymentUseCase) {
    useCase = paymentUseCase;
  }

    @PostMapping
    @Operation(summary = "Create a new payment", description = "Create a new payment")
    public ResponseEntity<FastfoodPayment> post(final @RequestBody PaymentNotification notification) {
        final var created = useCase.create(notification);
        if (created.isPresent()) {
            final var payment = created.get();
            final var uri = URI.create("/payments/" + payment.id());
            return ResponseEntity.created(uri).body(payment);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/webhook")
    @Operation(summary = "Mercado Pago webhook", description = "Mercado Pago webhook")
    public ResponseEntity<String> webhook(@RequestBody WebhookDto webhookVo) throws MPException, MPApiException{
        this.useCase.webhook(webhookVo);
        return ResponseEntity.ok("Received webhook");
    }
}
