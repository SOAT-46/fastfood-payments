package com.github.soat46.fastfood.infra.config;

import com.github.soat46.fastfood.shared.MercadoPagoSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MercadoPagoConfig {

  @Value("${integration.mercadopago.url}")
  private String url;

  @Value("${integration.mercadopago.path}")
  private String path;

  @Value("${integration.mercadopago.accesstoken}")
  private String accessToken;

  @Value("${integration.mercadopago.orderDataUrl}")
  private String orderDataUrl;

  @Value("${integration.mercadopago.notificationUrl}")
  private String notificationUrl;

  @Bean
  public MercadoPagoSettings settings() {
    return MercadoPagoSettings.builder()
        .url(url)
        .path(path)
        .accessToken(accessToken)
        .orderDataUrl(orderDataUrl)
        .notificationUrl(notificationUrl)
        .build();
  }
}
