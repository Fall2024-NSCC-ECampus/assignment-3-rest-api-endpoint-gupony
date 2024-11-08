package com.example.democourierservicemanagementsystem.controllers;

import com.example.democourierservicemanagementsystem.models.DeliveryDetails;
import com.example.democourierservicemanagementsystem.repositories.DeliveryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveryDetails")
public class DeliveryDetailsController {

    @Autowired
    private DeliveryDetailsRepository deliveryDetailsRepository;

    @GetMapping
    public List<DeliveryDetails> getAllDeliveryDetails() {
        return deliveryDetailsRepository.findAll();
    }

    @GetMapping("/{id}")
    public DeliveryDetails getDeliveryDetailsById(@PathVariable Long id) {
        return deliveryDetailsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public DeliveryDetails createDeliveryDetails(@RequestBody DeliveryDetails deliveryDetails) {
        return deliveryDetailsRepository.save(deliveryDetails);
    }

    @PutMapping("/{id}")
    public DeliveryDetails updateDeliveryDetails(@PathVariable Long id, @RequestBody DeliveryDetails updatedDetails) {
        return deliveryDetailsRepository.findById(id)
                .map(details -> {
                    details.setStatus(updatedDetails.getStatus());
                    details.setDeliveryDate(updatedDetails.getDeliveryDate());
                    details.setRecipientName(updatedDetails.getRecipientName());
                    details.setAddress(updatedDetails.getAddress());
                    return deliveryDetailsRepository.save(details);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteDeliveryDetails(@PathVariable Long id) {
        deliveryDetailsRepository.deleteById(id);
        return "Delivery details deleted";
    }
}
