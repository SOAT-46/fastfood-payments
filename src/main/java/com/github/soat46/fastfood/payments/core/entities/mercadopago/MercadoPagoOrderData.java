package com.github.soat46.fastfood.payments.core.entities.mercadopago;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MercadoPagoOrderData {

  private String id;
  private String status;
  private String statusDetail;

  @JsonProperty("external_reference")
  private String externalReference;

  private String paymentType;
  private String paymentMethodId;
  private String paymentMethodReferenceId;
  private String transactionAmount;
  private String totalPaidAmount;
}
