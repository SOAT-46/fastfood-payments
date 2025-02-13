package com.github.soat46.fastfood.payments.controller.dto;

import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WebhookDto {
    private String action;
    private String apiVersion;
    private WebhookDataDto data;
    private String dateCreated;
    private String id;
    private Boolean liveMode;
    private String type;
    private BigInteger userId;
}
