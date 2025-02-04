package com.github.soat46.fastfood.payments.core.usecase.interfaces;

import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;

public interface UpdatePaymentUseCase {

  void updateStatus(PaymentNotification notification);
}
