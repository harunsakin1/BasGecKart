package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.service.PassengerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	private PassengerService passengerService;
	
	public PassengerController(PassengerService passengerService) {
		this.passengerService = passengerService;
	}
}