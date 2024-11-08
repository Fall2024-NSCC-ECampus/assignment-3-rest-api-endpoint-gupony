package com.example.democourierservicemanagementsystem.controllers;

import com.example.democourierservicemanagementsystem.models.Payment;
import com.example.democourierservicemanagementsystem.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setAmount(updatedPayment.getAmount());
                    payment.setStatus(updatedPayment.getStatus());
                    payment.setPaymentDate(updatedPayment.getPaymentDate());
                    return paymentRepository.save(payment);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentRepository.deleteById(id);
        return "Payment deleted";
    }
}
