package com.haruns.basgeckart.service;

import com.haruns.basgeckart.dto.request.RegisterRequestDto;
import com.haruns.basgeckart.entity.Passenger;
import com.haruns.basgeckart.mapper.PassengerMapper;
import com.haruns.basgeckart.repository.PassengerRepository;
import com.haruns.basgeckart.views.VwPassenger;
import com.haruns.basgeckart.exception.ErrorType;
import com.haruns.basgeckart.exception.PassengerException;
import lombok.AllArgsConstructor;
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
	
	public void setCardToPassenger(Long cardId, Passenger passenger) {
		if (passenger==null){
			throw new PassengerException(ErrorType.PASSENGER_NOT_FOUND);
		}
		passenger.setCardId(cardId);
		updatePassenger(passenger);
	}
	
	public Passenger findPassengerById(Long id) {
		Optional<Passenger> optPassenger = passengerRepository.findById(id);
		if (optPassenger.isEmpty()){
			throw new PassengerException(ErrorType.PASSENGER_NOT_FOUND);
		}
		return optPassenger.get();
	}
}