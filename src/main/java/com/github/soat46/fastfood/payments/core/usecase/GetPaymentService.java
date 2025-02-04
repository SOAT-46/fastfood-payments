package com.github.soat46.fastfood.payments.core.usecase;

import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.GetPaymentPort;
import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.usecase.interfaces.GetPaymentUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class GetPaymentService implements GetPaymentUseCase {
  private final GetPaymentPort payment;

  public GetPaymentService(final GetPaymentPort getPort) {
    payment = getPort;
  }

  @Override
  public Optional<FastfoodPayment> get(final String paymentId) {
    final var found = payment.get(paymentId);
    if (found.isPresent()) {
      return Optional.of(FastfoodPayment.builder().build());
    }
    return Optional.empty();
  }
}
