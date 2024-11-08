package com.example.democourierservicemanagementsystem.repositories;

import com.example.democourierservicemanagementsystem.models.DeliveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryDetailsRepository extends JpaRepository<DeliveryDetails, Long> {
}
