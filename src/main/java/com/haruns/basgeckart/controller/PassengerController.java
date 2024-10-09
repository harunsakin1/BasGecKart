package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.dto.request.RegisterRequestDto;
import com.haruns.basgeckart.entity.Passenger;
import com.haruns.basgeckart.service.PassengerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/passenger")
public class PassengerController {
	private final PassengerService passengerService;
	@GetMapping("/add-all-passengers")
	public String addAllPassengers() {
		Passenger passenger = Passenger.builder()
		                               .email("asdas@")
		                               .address("Ankara")
		                               .tc("12312312323")
		                               .name("Mehemt")
		                               .surname("Ert")
		                               .avatar("url.dsfsdf")
		                               .birthDate(LocalDate.of(1999, 10, 3))
		                               .phone("05465464545")
		                               .build();
		Passenger passenger1 = Passenger.builder().email("asdad@").address("Bursa").tc("12312312324").name("Harun").surname("Ert").avatar("url.dsfsdf").birthDate(LocalDate.of(1999,10,3)).phone("05465464535").build();
		Passenger passenger2 = Passenger.builder().email("asdag@").address("Ankara").tc("12312312325").name("Alperen").surname("Ert").avatar("url.dsfsdf").birthDate(LocalDate.of(1999, 10, 3)).phone("05465474545").build();
		Passenger passenger3 = Passenger.builder().email("asdar@").address("Ankara").tc("12312312326").name("Burak").surname("Ert").avatar("url.dsfsdf").birthDate(LocalDate.of(1999,10,3)).phone("05465464145").build();
		
		passengerService.addAllPassengers(List.of(passenger, passenger1, passenger2, passenger3));
		
		return "Kayıtlar başarı ile eklendi";
	}
	
	@GetMapping("/set-card-to-passenger")
	public String setCardToPassenger() {
		Long cardId = 1L;
		List<Passenger> passengerList = findAll();
		for (Passenger passenger :passengerList){
			passenger.setCardId(cardId);
			passengerService.updatePassenger(passenger);
			
			cardId++;
			
		}
		return "Kart atandı";
	}
	
	public List<Passenger> findAll() {
		return passengerService.findAll();
	}
	
	@PostMapping("/register")
	public Passenger register(@RequestBody @Valid RegisterRequestDto dto){
		return passengerService.register(dto);
	}
	
}