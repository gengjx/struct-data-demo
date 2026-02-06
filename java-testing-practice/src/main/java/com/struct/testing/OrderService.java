package com.struct.testing;

public class OrderService {

    private final NotificationClient notificationClient;
    private final DiscountCalculator discountCalculator;

    public OrderService(NotificationClient notificationClient, DiscountCalculator discountCalculator) {
        this.notificationClient = notificationClient;
        this.discountCalculator = discountCalculator;
    }

    public int createOrder(String userEmail, int originPrice, int discountRate) {
        int finalPrice = discountCalculator.finalPrice(originPrice, discountRate);
        notificationClient.send(userEmail, "order created, finalPrice=" + finalPrice);
        return finalPrice;
    }
}
