package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/card")
public class CardController {
	private final CardService cardService;
	
	
}