package com.kafka.resturant.madhuram.application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.kafka.resturant.madhuram.application.Model.CustomerMessage;
import com.kafka.resturant.madhuram.application.Model.DeliveryMessage;

@SpringBootApplication
public class DeliveryService {

    @Autowired
    private KafkaTemplate<String, DeliveryMessage> kafkaTemplate;

    @KafkaListener(topics = "customer-requests")
    public void handleCustomerRequest(CustomerMessage message) {
        // Process customer request and prepare delivery boy response
        DeliveryMessage response = prepareDeliveryBoyResponse("Your order is on the way ");

        // Send response to customer topic
        kafkaTemplate.send("customer-responses", response);
    }

    public DeliveryMessage prepareDeliveryBoyResponse(String messageContent) {
        return new DeliveryMessage("order123", "on_the_way", messageContent, messageContent, messageContent);
    }

}
