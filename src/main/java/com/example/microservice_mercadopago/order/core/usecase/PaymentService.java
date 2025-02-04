package com.example.microservice_mercadopago.order.core.usecase;


import com.example.microservice_mercadopago.order.adapters.external.MercadoPagoIntegrationPort;
import com.example.microservice_mercadopago.order.adapters.repository.OrderSnackRepository;
import com.example.microservice_mercadopago.order.adapters.repository.entities.OrderSnackEntity;
import com.example.microservice_mercadopago.order.core.entities.enums.OrderProgress;
import com.example.microservice_mercadopago.order.core.entities.enums.PaymentProgress;
import com.example.microservice_mercadopago.order.core.entities.payment.OrderSnackPaymentStatus;
import com.example.microservice_mercadopago.order.core.entities.payment.PaymentNotification;
import com.example.microservice_mercadopago.order.core.usecase.interfaces.PaymentUseCase;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class PaymentService implements PaymentUseCase {
    @Autowired
    MercadoPagoIntegrationPort mercadoPagoIntegrationPort;
    @Autowired
    OrderSnackRepository orderSnackRepository;

    public void updatePaymentStatus(PaymentNotification notification) {
        try{
            log.info("Updating payment status for order: " + notification.getData().getId());
            OrderSnackPaymentStatus mercadoPagoOrderData = mercadoPagoIntegrationPort.getOrderData(notification.getData().getId());
            OrderSnackEntity orderSnackEntity = orderSnackRepository.findByExternalOrderId(String.valueOf(mercadoPagoOrderData.getExternalOrderId()));
            orderSnackEntity.setPaymentProgress(generatePaymentStatus(mercadoPagoOrderData.getPaymentStatus()));
            orderSnackEntity.setProgress(setOrderStatus(orderSnackEntity.getPaymentProgress()));
            log.info("Payment status updated to: " + orderSnackEntity.getPaymentProgress());
            orderSnackRepository.save(orderSnackEntity);
            log.info("Payment status updated successfully");
        }catch (Exception e){
            log.error("Error updating payment status: " + e.getMessage());
            throw new RuntimeException("Error updating payment status: " + e.getMessage());
        }
    }


    private PaymentProgress generatePaymentStatus(String status){
        return switch (status) {
            case "approved" -> PaymentProgress.APPROVED;
            case "opened" -> PaymentProgress.OPPENED;
            case "expired" -> PaymentProgress.EXPIRED;
            default -> throw new UnsupportedOperationException("Payment status" + status + " not supported, choose between: closed, opened or expired");
        };
    }

    private OrderProgress setOrderStatus(PaymentProgress paymentProgress){
        if(paymentProgress.equals(PaymentProgress.APPROVED)){
            return OrderProgress.IN_PREPARATION;
        }else{
            return OrderProgress.RECEIVED;
        }
    }
}