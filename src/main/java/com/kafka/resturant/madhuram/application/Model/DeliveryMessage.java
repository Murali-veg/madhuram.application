package com.kafka.resturant.madhuram.application.Model;

public class DeliveryMessage {

    private final String orderId;
    private final String deliveryBoyId;
    private final String status;
    private final String estimatedTime;
    private final String message;

    public DeliveryMessage(String orderId, String deliveryBoyId, String status, String estimatedTime, String message) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("orderId cannot be null or empty");
        }

        this.orderId = orderId;
        this.deliveryBoyId = deliveryBoyId;
        this.status = status;
        this.estimatedTime = estimatedTime;
        this.message = message;

    }
}