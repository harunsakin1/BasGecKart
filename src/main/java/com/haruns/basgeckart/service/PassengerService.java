package com.haruns.basgeckart.service;

import com.haruns.basgeckart.dto.request.RegisterRequestDto;
import com.haruns.basgeckart.entity.Card;
import com.haruns.basgeckart.entity.Passenger;
import com.haruns.basgeckart.repository.PassengerRepository;
import com.haruns.basgeckart.views.VwPassenger;
import com.haruns.exception.CardException;
import com.haruns.exception.ErrorType;
import com.haruns.exception.PassengerException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
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
		Passenger passenger = passengerRepository.findByTc(tc);
//		if (passenger!=null){
//			throw new PassengerException(ErrorType.PASSENGER_NOT_FOUND);
//		}
//		else {
//			return passenger;
//		}
//		return passengerRepository.findByTc(tc).orElseThrow(()->new PassengerException(ErrorType.PASSENGER_NOT_FOUND));
		return passenger;
		
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
		if (passenger==null){
			throw new PassengerException(ErrorType.PASSENGER_NOT_FOUND);
		}
		passenger.setCardId(cardId);
		updatePassenger(passenger);
	}
	
}