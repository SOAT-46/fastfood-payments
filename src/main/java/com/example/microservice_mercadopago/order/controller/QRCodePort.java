package com.example.microservice_mercadopago.order.controller;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodePort {
    byte[] generateQRCodeImage(String text, int width, int height)  throws WriterException, IOException;
}
