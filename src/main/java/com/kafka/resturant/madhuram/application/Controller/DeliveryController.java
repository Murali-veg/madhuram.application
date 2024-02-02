package com.kafka.resturant.madhuram.application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.resturant.madhuram.application.Model.DeliveryMessage;
import com.kafka.resturant.madhuram.application.Service.DeliveryService;

@RestController
public class DeliveryController {

    @Autowired
    private KafkaTemplate<String, DeliveryMessage> kafkaTemplate;

    @PostMapping("/send-order-update")
    public void sendOrderUpdate(@RequestParam String messageContent) {
        DeliveryService deliveryService = new DeliveryService();
        DeliveryMessage response = deliveryService.prepareDeliveryBoyResponse(messageContent);
        kafkaTemplate.send("customer-responses", response);
    }
}