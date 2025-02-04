package com.example.microservice_mercadopago.order.core.usecase;

import com.example.microservice_mercadopago.order.controller.DTO.OrderItemRequest;
import com.example.microservice_mercadopago.order.controller.DTO.OrderSnackRequest;
import com.example.microservice_mercadopago.order.adapters.external.MercadoPagoIntegrationPort;
import com.example.microservice_mercadopago.order.adapters.repository.OrderSnackPort;
import com.example.microservice_mercadopago.order.controller.QRCodePort;
import com.example.microservice_mercadopago.order.core.entities.OrderSnack;
import com.example.microservice_mercadopago.order.core.entities.OrderSnackItem;
import com.example.microservice_mercadopago.order.core.entities.mercadopago.QRCodeData;
import com.example.microservice_mercadopago.order.core.usecase.interfaces.CreateOrderSnackUseCase;
import com.example.microservice_mercadopago.order.utils.OrderSnackMapper;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CreateOrderSnackService implements CreateOrderSnackUseCase {

    @Autowired
    private final MercadoPagoIntegrationPort mercadoPagoIntegrationPort;
    @Autowired
    private final QRCodePort qrCodePort;
    @Autowired
    private final OrderSnackPort orderSnackPort;



    @Override
    public byte[] requestOrder(OrderSnackRequest  orderSnackRequest) {
        UUID externalReference = UUID.randomUUID();

        List<OrderSnackItem> listOfOrderItems = generateListOfOrderItems(orderSnackRequest.getItems());
        OrderSnack orderSnack = new OrderSnack();
        orderSnack.setItems(listOfOrderItems);
        QRCodeData qrData = mercadoPagoIntegrationPort.requestQrData(orderSnack, externalReference);
        try {
            byte[] qrCodeImg = qrCodePort.generateQRCodeImage(qrData.getQrData(), 250, 250);
            orderSnackPort.saveOrderSnack(orderSnack, externalReference);
            return qrCodeImg;
        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<OrderSnackItem> generateListOfOrderItems(List<OrderItemRequest> list) {
        return list.stream().
            map(item -> generateOrderItem(item.getProductId(), item.getQtd()))
                .collect(Collectors.toList());
    }

    private OrderSnackItem generateOrderItem(int qtd){
        BigDecimal quantityAsBigDecimal = BigDecimal.valueOf(qtd);
        BigDecimal fullValue = product.getPrice().multiply(quantityAsBigDecimal);
        return new OrderSnackItem(null, null , fullValue, product,qtd );
    }

}
