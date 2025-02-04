package com.github.soat46.fastfood.payments.core.usecase.interfaces;

import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;

import java.util.Optional;

public interface GetPaymentUseCase {

  Optional<FastfoodPayment> get(String paymentId);
}
