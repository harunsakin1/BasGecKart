package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {
	private final PaymentService paymentService;
	
	
}