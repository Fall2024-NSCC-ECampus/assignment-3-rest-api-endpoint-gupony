package com.example.democourierservicemanagementsystem.repositories;

import com.example.democourierservicemanagementsystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
