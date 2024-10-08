package com.haruns.basgeckart.service;

import com.haruns.basgeckart.dto.request.RegisterRequestDto;
import com.haruns.basgeckart.entity.Passenger;
import com.haruns.basgeckart.repository.PassengerRepository;
import com.haruns.basgeckart.views.VwPassenger;
import jakarta.validation.Valid;
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
	public List<VwPassenger> findAll() {
		return passengerRepository.findAllPassengers();
	}
	public Passenger findPassengerByTc(String tc){
		return passengerRepository.findByTc(tc);
	}
	public Passenger register(RegisterRequestDto dto) {
		return passengerRepository.save(Passenger.builder()
				                                 .name(dto.getName())
				                                 .surname(dto.getSurname())
				                                 .tc(dto.getTc())
				                                 .birthDate(dto.getBirthDate())
				                                 .address(dto.getAddress())
				                                 .build());
	}
	
	public void setCardToPassenger(Long cardId, Passenger passenger) {
		passenger.setCardId(cardId);
		updatePassenger(passenger);
	}
}