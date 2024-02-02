package com.kafka.resturant.madhuram.application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import com.kafka.resturant.madhuram.application.Model.CustomerMessage;
import com.kafka.resturant.madhuram.application.Model.DeliveryMessage;

@SpringBootApplication
public class CustomerService {

    @Autowired
    private KafkaTemplate<String, CustomerMessage> kafkaTemplate;

    @KafkaListener(topics = "delivery-boy-responses")
    public void handleDeliveryBoyResponse(DeliveryMessage message) {
    }

}
