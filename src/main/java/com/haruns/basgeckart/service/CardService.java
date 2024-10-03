package com.haruns.basgeckart.service;

import com.haruns.basgeckart.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CardService {
	private final CardRepository cardRepository;
	
	
}