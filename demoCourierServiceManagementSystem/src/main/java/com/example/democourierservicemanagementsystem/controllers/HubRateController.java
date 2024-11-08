package com.example.democourierservicemanagementsystem.controllers;

import com.example.democourierservicemanagementsystem.models.HubRate;
import com.example.democourierservicemanagementsystem.repositories.HubRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hubRates")
public class HubRateController {

    @Autowired
    private HubRateRepository hubRateRepository;

    @GetMapping
    public List<HubRate> getAllHubRates() {
        return hubRateRepository.findAll();
    }

    @GetMapping("/{id}")
    public HubRate getHubRateById(@PathVariable Long id) {
        return hubRateRepository.findById(id).orElse(null);
    }

    @PostMapping
    public HubRate createHubRate(@RequestBody HubRate hubRate) {
        return hubRateRepository.save(hubRate);
    }

    @PutMapping("/{id}")
    public HubRate updateHubRate(@PathVariable Long id, @RequestBody HubRate updatedHubRate) {
        return hubRateRepository.findById(id)
                .map(hubRate -> {
                    hubRate.setLocation(updatedHubRate.getLocation());
                    hubRate.setRate(updatedHubRate.getRate());
                    return hubRateRepository.save(hubRate);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteHubRate(@PathVariable Long id) {
        hubRateRepository.deleteById(id);
        return "Hub rate deleted";
    }
}
