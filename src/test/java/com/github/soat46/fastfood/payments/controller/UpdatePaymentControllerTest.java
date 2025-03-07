package com.github.soat46.fastfood.payments.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotification;
import com.github.soat46.fastfood.payments.core.entities.payment.PaymentNotificationData;
import com.github.soat46.fastfood.payments.core.usecase.UpdatePaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UpdatePaymentControllerTest {

    @InjectMocks
    private UpdatePaymentController controller;

    @Mock
    private UpdatePaymentService updatePaymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnNotFoundWhenIdIsBlank() throws JsonProcessingException {
        // Arrange
        PaymentNotificationData paymentNotificationData = new PaymentNotificationData();
        paymentNotificationData.setId(""); // ID em branco

        PaymentNotification notification = new PaymentNotification();
        notification.setData(paymentNotificationData);

        // Act
        ResponseEntity<?> response = controller.post(notification);

        // Assert
        assertEquals(404, response.getStatusCodeValue());
        verify(updatePaymentService, never()).updateStatus(any());
    }

    @Test
    void shouldUpdatePaymentStatusWhenNotificationIsValid() throws JsonProcessingException {
        // Arrange
        PaymentNotificationData paymentNotificationData = new PaymentNotificationData();
        paymentNotificationData.setId("12345"); // ID válido

        PaymentNotification notification = new PaymentNotification();
        notification.setData(paymentNotificationData);

        // Act
        ResponseEntity<?> response = controller.post(notification);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        verify(updatePaymentService, times(1)).updateStatus(notification);
    }
}
