package com.github.soat46.fastfood.payments.controller;

import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.github.soat46.fastfood.payments.core.usecase.interfaces.CreatePaymentUseCase;
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
public class CreatePaymentController {
    private final CreatePaymentUseCase useCase;

    public CreatePaymentController(final CreatePaymentUseCase paymentUseCase) {
    useCase = paymentUseCase;
  }

    @PostMapping
    public ResponseEntity<FastfoodPayment> post(final @RequestBody PaymentNotification notification) {
        final var created = useCase.create(notification);
        if (created.isPresent()) {
            final var payment = created.get();
            final var uri = URI.create("/payments/" + payment.id());
            return ResponseEntity.created(uri).body(payment);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<String> webhook(@RequestBody WebhookDto webhookVo) {
        try {
            this.useCase.webhookHandle(webhookVo);
        } catch (MPException e) {
            throw new MPException(e);
        } catch (MPApiException e) {
            throw new MPApiException(e);
        }

        return ResponseEntity.ok("Received webhook");
    }
}
