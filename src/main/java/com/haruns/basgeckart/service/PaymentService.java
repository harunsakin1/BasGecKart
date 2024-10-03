package com.haruns.basgeckart.service;

import com.haruns.basgeckart.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	private PaymentRepository paymentRepository;
	
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
}