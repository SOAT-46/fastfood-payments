package com.github.soat46.fastfood.infra.config;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MercadoPagoClientConfig {

  @Value("${integration.mercadopago.accesstoken}")
  private String accessToken;

  @Bean
  public PaymentClient paymentClient() {
    MercadoPagoConfig.setAccessToken(accessToken);
    return new PaymentClient();
  }
}
