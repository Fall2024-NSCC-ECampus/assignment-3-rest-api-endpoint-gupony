package com.example.democourierservicemanagementsystem.controllers;

import com.example.democourierservicemanagementsystem.models.Review;
import com.example.democourierservicemanagementsystem.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        return reviewRepository.findById(id)
                .map(review -> {
                    review.setContent(updatedReview.getContent());
                    review.setRating(updatedReview.getRating());
                    return reviewRepository.save(review);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
        return "Review deleted";
    }
}
