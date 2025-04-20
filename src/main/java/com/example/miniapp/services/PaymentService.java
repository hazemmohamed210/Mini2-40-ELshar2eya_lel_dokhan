package com.example.miniapp.services;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment) { return paymentRepository.save(payment); }

    public List<Payment> getAllPayments() { return paymentRepository.findAll(); }

    public Payment getPaymentById(Long id){ return paymentRepository.findById(id).orElse(null); }

    public Payment updatePayment(Long id, Payment payment){
        Payment existing = getPaymentById(id);
        existing.setAmount(payment.getAmount());
        existing.setPaymentMethod(payment.getPaymentMethod());
        existing.setPaymentStatus(payment.getPaymentStatus());
        existing.setTrip(payment.getTrip());
        return paymentRepository.save(existing);
    }

    public void deletePayment(Long id){
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
        }
    }

    public List<Payment> findPaymentsByTripId(Long tripId){
        Payment payment = paymentRepository.findByTrip_Id(tripId);
        if (payment == null) {
            return List.of();
        } else {
            return List.of(payment);
        }
    }

    public List<Payment> findByAmountThreshold(Double threshold){ return paymentRepository.findByAmountGreaterThan(threshold); }
}
