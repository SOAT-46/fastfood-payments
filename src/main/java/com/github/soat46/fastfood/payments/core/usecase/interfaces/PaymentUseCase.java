package com.github.soat46.fastfood.payments.core.usecase.interfaces;

import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;

import java.util.Optional;

public interface PaymentUseCase {

  Optional<FastfoodPayment> get(String paymentId);

  Optional<FastfoodPayment> create(PaymentNotification payment);

  void updatePaymentStatus(PaymentNotification notification);
}
