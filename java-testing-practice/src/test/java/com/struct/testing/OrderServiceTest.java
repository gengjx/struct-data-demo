package com.struct.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OrderServiceTest {

    @Test
    void createOrder_shouldSendNotification() {
        NotificationClient notificationClient = Mockito.mock(NotificationClient.class);
        DiscountCalculator calculator = Mockito.spy(new DiscountCalculator());

        OrderService orderService = new OrderService(notificationClient, calculator);

        int finalPrice = orderService.createOrder("a@b.com", 200, 10);
        Assertions.assertEquals(180, finalPrice);

        Mockito.verify(calculator).finalPrice(200, 10);
        Mockito.verify(notificationClient).send("a@b.com", "order created, finalPrice=180");
    }
}
