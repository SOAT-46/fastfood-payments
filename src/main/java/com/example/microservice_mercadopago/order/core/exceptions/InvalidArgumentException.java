package com.example.microservice_mercadopago.order.core.exceptions;

public class InvalidArgumentException extends RuntimeException{
    public InvalidArgumentException(String message) {
        super(message);
    }
}
