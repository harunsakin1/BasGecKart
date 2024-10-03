package com.haruns.basgeckart.service;

import com.haruns.basgeckart.repository.PassengerRepository;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
	private PassengerRepository passengerRepository;
	
	public PassengerService(PassengerRepository passengerRepository) {
		this.passengerRepository = passengerRepository;
	}
}