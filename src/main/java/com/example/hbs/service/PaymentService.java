package com.example.hbs.service;

import com.example.hbs.domain.Account;
import com.example.hbs.domain.Customer;
import com.example.hbs.domain.Payment;
import com.example.hbs.repo.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Customer cardHolder, String cardNum, LocalDateTime paymentDate, Double paymentAmount){
        return paymentRepository.save(new Payment(cardHolder, cardNum, paymentDate, paymentAmount));
    }

}
