package com.haruns.basgeckart.service;

import com.haruns.basgeckart.repository.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService {
	private CardRepository cardRepository;
	
	public CardService(CardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}
}