package com.haruns.basgeckart.service;

import com.haruns.basgeckart.dto.request.RegisterRequestDto;
import com.haruns.basgeckart.dto.request.UpdatePassengerProfileDto;
import com.haruns.basgeckart.entity.Passenger;
import com.haruns.basgeckart.exception.CardException;
import com.haruns.basgeckart.mapper.PassengerMapper;
import com.haruns.basgeckart.repository.PassengerRepository;
import com.haruns.basgeckart.service.proxy.CardServiceProxy;
import com.haruns.basgeckart.views.VwPassenger;
import com.haruns.basgeckart.exception.ErrorType;
import com.haruns.basgeckart.exception.PassengerException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class PassengerService {

	private final PassengerRepository passengerRepository;
	private final CardServiceProxy cardServiceProxy;
	
	
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
	public boolean existByTc(String tc) {
		if (!passengerRepository.existsByTc(tc)) {
			System.out.println("EXIST BY TC");
			throw new PassengerException(ErrorType.PASSENGER_NOT_FOUND);
		}
		return true;
	}
	
	public Passenger register(RegisterRequestDto dto) {
		Passenger passenger= PassengerMapper.INSTANCE.fromRegisterRequestDto(dto);
		return passengerRepository.save(passenger);
	}
	
	public void setCardToPassenger(Long cardId, Long passengerId) {
		if(isCardAlreadySetted(cardId)){
			throw new CardException(ErrorType.CARD_ALREADY_SETTED);
		}
		if (!cardServiceProxy.getCardService().existById(cardId)){
		throw new CardException(ErrorType.CARD_NOT_FOUND);
		}
		Passenger passenger = findPassengerById(passengerId);
		if (passengerId==null) {
			throw new PassengerException(ErrorType.PASSENGER_NOT_FOUND);
		}
		passenger.setCardId(cardId);
		updatePassenger(passenger);
	}
	
	
	public boolean isCardAlreadySetted(Long cardId) {
		return passengerRepository.isCardAlreadySetted(cardId);
	}
	
	public Passenger findPassengerById(Long id) {
		Optional<Passenger> optPassenger = passengerRepository.findById(id);
		if (optPassenger.isEmpty()){
			throw new PassengerException(ErrorType.PASSENGER_NOT_FOUND);
		}
		return optPassenger.get();
	}
	
	public void updatePassengerProfile(@Valid UpdatePassengerProfileDto dto) {
	Passenger passenger=PassengerMapper.INSTANCE.fromUpdatePassengerProfileDto(dto);
	passengerRepository.save(passenger);
	}
}