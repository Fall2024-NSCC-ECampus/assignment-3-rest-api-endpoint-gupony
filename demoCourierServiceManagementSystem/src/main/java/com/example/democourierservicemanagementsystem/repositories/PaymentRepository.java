package com.example.democourierservicemanagementsystem.repositories;

import com.example.democourierservicemanagementsystem.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
