package com.example.democourierservicemanagementsystem.repositories;

import com.example.democourierservicemanagementsystem.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
