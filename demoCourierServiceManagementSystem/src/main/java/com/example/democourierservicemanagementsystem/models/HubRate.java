package com.example.democourierservicemanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HubRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private Double rate;

    public HubRate() {}

    public HubRate(Long id, String location, Double rate) {
        this.id = id;
        this.location = location;
        this.rate = rate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Double getRate() { return rate; }
    public void setRate(Double rate) { this.rate = rate; }
}
