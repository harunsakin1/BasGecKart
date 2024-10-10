package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.dto.request.RegisterRequestDto;
import com.haruns.basgeckart.dto.response.BaseResponse;
import com.haruns.basgeckart.entity.Card;
import com.haruns.basgeckart.entity.Passenger;
import com.haruns.basgeckart.service.PassengerService;
import com.haruns.basgeckart.views.VwPassenger;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.haruns.basgeckart.constants.RestApis.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(PASSENGER)
public class PassengerController {
	private final PassengerService passengerService;
	@GetMapping(ADD_ALL_PASSENGERS)
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
	
	@PostMapping(SET_CARD_TO_PASSENGER)
	public void setCardToPassenger(Long cardId,Passenger passenger) {
		passengerService.setCardToPassenger(cardId, passenger);
	}
	
	@GetMapping(FIND_ALL_PASSENGERS)
	public ResponseEntity<BaseResponse<List<VwPassenger>>> findAll() {
		return ResponseEntity.ok(BaseResponse.<List<VwPassenger>>builder()
				                         .success(true)
				                         .code(200)
				                         .message("Passenger listesi başarıyla getirildi")
				                         .data(passengerService.findAll())
		                     .build()
		);
	}
	
	@PostMapping(REGISTER)
	public Passenger register(@RequestBody @Valid RegisterRequestDto dto){
		return passengerService.register(dto);
	}
	
}