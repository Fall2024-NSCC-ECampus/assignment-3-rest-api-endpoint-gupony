package com.example.democourierservicemanagementsystem.controllers;

import com.example.democourierservicemanagementsystem.models.NonDeliveryDetails;
import com.example.democourierservicemanagementsystem.repositories.NonDeliveryDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nonDeliveryDetails")
public class NonDeliveryDetailsController {

    @Autowired
    private NonDeliveryDetailsRepository nonDeliveryDetailsRepository;

    @GetMapping
    public List<NonDeliveryDetails> getAllNonDeliveryDetails() {
        return nonDeliveryDetailsRepository.findAll();
    }

    @GetMapping("/{id}")
    public NonDeliveryDetails getNonDeliveryDetailsById(@PathVariable Long id) {
        return nonDeliveryDetailsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public NonDeliveryDetails createNonDeliveryDetails(@RequestBody NonDeliveryDetails nonDeliveryDetails) {
        return nonDeliveryDetailsRepository.save(nonDeliveryDetails);
    }

    @PutMapping("/{id}")
    public NonDeliveryDetails updateNonDeliveryDetails(@PathVariable Long id, @RequestBody NonDeliveryDetails updatedDetails) {
        return nonDeliveryDetailsRepository.findById(id)
                .map(details -> {
                    details.setReason(updatedDetails.getReason());
                    details.setAttemptDate(updatedDetails.getAttemptDate());
                    return nonDeliveryDetailsRepository.save(details);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteNonDeliveryDetails(@PathVariable Long id) {
        nonDeliveryDetailsRepository.deleteById(id);
        return "Non-delivery details deleted";
    }
}
