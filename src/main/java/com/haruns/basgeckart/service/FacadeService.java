package com.haruns.basgeckart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FacadeService {
	public static PassengerService passengerService;
	public static CardService cardService;
	
//	public FacadeService( PassengerService passengerService, CardService cardService ) {
//		this.passengerService = passengerService;
//		this.cardService = cardService;
//	}
	
}