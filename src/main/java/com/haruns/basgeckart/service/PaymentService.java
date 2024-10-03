package com.haruns.basgeckart.service;

import com.haruns.basgeckart.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaymentService {
	private final PaymentRepository paymentRepository;
}