package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/passenger")
public class PassengerController {
	private final PassengerService passengerService;
	
	
}