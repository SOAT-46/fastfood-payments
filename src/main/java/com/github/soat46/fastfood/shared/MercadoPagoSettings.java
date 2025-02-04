package com.github.soat46.fastfood.shared;

import lombok.Builder;
import lombok.Getter;

@Builder
public class MercadoPagoSettings {
  private String url;
  private String path;
  private String accessToken;
  private String orderDataUrl;
  @Getter private String notificationUrl;

  public String getQRCodeURL() {
    return url + "/" + path + "?access_token=" + accessToken;
  }

  public String getOrderURL(String paymentId) {
    return orderDataUrl + "/" + paymentId + "?access_token=" + accessToken;
  }
}
