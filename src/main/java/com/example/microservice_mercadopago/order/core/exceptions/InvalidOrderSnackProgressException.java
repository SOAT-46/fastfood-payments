package com.example.microservice_mercadopago.order.core.exceptions;

public class InvalidOrderSnackProgressException extends RuntimeException {
    public InvalidOrderSnackProgressException(String message) {
        super(message);
    }
}
