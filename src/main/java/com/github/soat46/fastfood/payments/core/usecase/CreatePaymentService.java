package com.github.soat46.fastfood.payments.core.usecase;

import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.CreatePaymentPort;
import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.MercadoPagoIntegrationPort;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.github.soat46.fastfood.payments.core.usecase.interfaces.CreatePaymentUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CreatePaymentService implements CreatePaymentUseCase {

  private final MercadoPagoIntegrationPort mercadoPagoPort;
  private final CreatePaymentPort createPayment;

  public CreatePaymentService(
      final MercadoPagoIntegrationPort mercadoPort, final CreatePaymentPort paymentPort) {
    mercadoPagoPort = mercadoPort;
    createPayment = paymentPort;
  }

  @Override
  public Optional<FastfoodPayment> create(final PaymentNotification input) {
    final var payment = mercadoPagoPort.create(input);
    if (payment.isPresent()) {
      return createPayment.create(payment.get());
    }
    return Optional.empty();
  }
}
