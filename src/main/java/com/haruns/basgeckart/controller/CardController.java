package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.service.CardService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
	private CardService cardService;
	
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}
}