package com.github.soat46.fastfood.payments.adapters.gateways.interfaces;

import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;

import java.util.Optional;

public interface CreatePaymentPort {

  Optional<FastfoodPayment> create(FastfoodPayment fastfoodPayment);
}
