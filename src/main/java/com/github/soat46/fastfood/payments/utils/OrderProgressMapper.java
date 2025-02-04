package com.github.soat46.fastfood.payments.utils;

import com.github.soat46.fastfood.payments.core.entities.enums.OrderProgress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderProgressMapper {
  OrderProgress toOrderProgress(OrderProgress orderProgress);
}
