package com.github.soat46.fastfood.payments.adapters.gateways;

import com.github.soat46.fastfood.payments.adapters.gateways.interfaces.OrderPort;
import com.github.soat46.fastfood.payments.core.entities.OrderSnack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class OrderAdapter implements OrderPort {

  @Override
  public Optional<OrderSnack> getById(final String orderId) {
    return Optional.empty();
  }

  @Override
  public void update(final OrderSnack order) {}
}
