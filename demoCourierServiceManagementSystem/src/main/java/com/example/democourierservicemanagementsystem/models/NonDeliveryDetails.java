package com.example.democourierservicemanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class NonDeliveryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reason;
    private Date attemptDate;

    public NonDeliveryDetails() {}

    public NonDeliveryDetails(Long id, String reason, Date attemptDate) {
        this.id = id;
        this.reason = reason;
        this.attemptDate = attemptDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public Date getAttemptDate() { return attemptDate; }
    public void setAttemptDate(Date attemptDate) { this.attemptDate = attemptDate; }
}
