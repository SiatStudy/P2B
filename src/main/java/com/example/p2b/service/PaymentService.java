package com.example.p2b.service;

import com.example.p2b.domain.Payment;
import com.example.p2b.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    public final PaymentRepository paymentRepository;

    @Transactional
    public void addPayment(Payment payment){
        paymentRepository.save(payment);
    }
}