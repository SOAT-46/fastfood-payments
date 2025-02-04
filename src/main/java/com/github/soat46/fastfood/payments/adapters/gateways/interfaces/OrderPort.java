package com.github.soat46.fastfood.payments.adapters.gateways.interfaces;

import com.github.soat46.fastfood.payments.core.entities.OrderSnack;

import java.util.Optional;

public interface OrderPort {

  Optional<OrderSnack> getById(String orderId);

  void update(OrderSnack order);
}
