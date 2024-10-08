package com.haruns.basgeckart.service;

import com.haruns.basgeckart.entity.Passenger;
import com.haruns.basgeckart.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassengerService {
	private final PassengerRepository passengerRepository;
	public void addPassenger(Passenger passenger) {
		passengerRepository.save(passenger);
	}
	
	public void addAllPassengers(List<Passenger> passengers) {
		passengerRepository.saveAll(passengers);
	}
	
	public void updatePassenger(Passenger passenger) {
		passengerRepository.saveAndFlush(passenger);
	}
	public List<Passenger> findAll() {
		return passengerRepository.findAll();
	}
	
}