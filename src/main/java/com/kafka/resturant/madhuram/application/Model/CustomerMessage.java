package com.kafka.resturant.madhuram.application.Model;

public class CustomerMessage {

    private final String orderId;
    private final String customerName;
    private final String address;

    public CustomerMessage(String orderId, String customerName, String address) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("orderId cannot be null or empty");
        }
        if (customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException("customerName cannot be null or empty");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("address cannot be null or empty");
        }
        this.orderId = orderId;
        this.customerName = customerName;
        this.address = address;
    }

    public String getOrderId() {

        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

}