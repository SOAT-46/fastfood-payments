package com.github.soat46.fastfood.payments.adapters.gateways.interfaces;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodePort {
  byte[] generateQRCodeImage(String text, int width, int height)
      throws WriterException, IOException;
}
