package com.haruns.basgeckart.service;

import com.haruns.basgeckart.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PassengerService {
	private final PassengerRepository passengerRepository;
	
	
}