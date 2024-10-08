package com.haruns.basgeckart.service;

import com.haruns.basgeckart.entity.Card;
import com.haruns.basgeckart.repository.CardRepository;
import com.haruns.basgeckart.utility.enums.PaymentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CardService {
	private final CardRepository cardRepository;
	
	public void addAllCard(List<Card> cardList) {
		cardRepository.saveAll(cardList);
	}
	
	public Optional<Card> findCardById(Long cardId){
		return cardRepository.findById(cardId);
	}
	public void saveCard(Card card){
		cardRepository.save(card);
	}
	
	
	
}