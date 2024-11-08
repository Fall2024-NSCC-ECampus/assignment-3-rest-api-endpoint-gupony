package com.example.democourierservicemanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class DeliveryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Date deliveryDate;
    private String recipientName;
    private String address;

    public DeliveryDetails() {}

    public DeliveryDetails(Long id, String status, Date deliveryDate, String recipientName, String address) {
        this.id = id;
        this.status = status;
        this.deliveryDate = deliveryDate;
        this.recipientName = recipientName;
        this.address = address;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(Date deliveryDate) { this.deliveryDate = deliveryDate; }

    public String getRecipientName() { return recipientName; }
    public void setRecipientName(String recipientName) { this.recipientName = recipientName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
