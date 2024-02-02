package com.kafka.resturant.madhuram.application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.resturant.madhuram.application.Model.CustomerMessage;
import com.kafka.resturant.madhuram.application.Model.DeliveryMessage;
import com.kafka.resturant.madhuram.application.Repository.CustomerResponseRepository;

@RestController
public class CustomerController {

    @Autowired
    private KafkaTemplate<String, CustomerMessage> kafkaTemplate;

    @Autowired
    private CustomerResponseRepository responseRepository;

    @PostMapping("/requests")
    public void sendRequest(@RequestBody CustomerMessage message) {
        try {
            kafkaTemplate.send("customer-requests", message);
        } catch (Exception e) {

        }
    }

    @GetMapping("/responses")
    public List<DeliveryMessage> getResponses() {
        return responseRepository.findResponsesForCurrentCustomer();
    }
}
