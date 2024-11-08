package com.example.democourierservicemanagementsystem.repositories;

import com.example.democourierservicemanagementsystem.models.NonDeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonDeliveryDetailsRepository extends JpaRepository<NonDeliveryDetails, Long> {
}
