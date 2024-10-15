package com.haruns.basgeckart.service;

import com.haruns.basgeckart.dto.request.AddBalanceRequestDto;
import com.haruns.basgeckart.entity.Card;
import com.haruns.basgeckart.entity.Recharge;
import com.haruns.basgeckart.mapper.RechargeMapper;
import com.haruns.basgeckart.repository.RechargeRepository;
import com.haruns.basgeckart.exception.CardException;
import com.haruns.basgeckart.exception.ErrorType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RechargeService {
	RechargeRepository rechargeRepository;
	CardService cardService;
	
	
	public void addRecharge(AddBalanceRequestDto dto) {
		Recharge recharge= RechargeMapper.INSTANCE.fromAddBalanceRequestDto(dto);
		rechargeRepository.save(recharge);
	}
	
	public void addBalance(AddBalanceRequestDto dto) {
		Optional<Card> optCard = cardService.findCardByNumber(dto.getCardNumber());
		if (optCard.isEmpty()){
			throw new CardException(ErrorType.CARD_NOT_FOUND);
		}
			Card card = optCard.get();
			card.setBalance(card.getBalance() + dto.getAmount());
			addRecharge(dto);
			cardService.saveCard(card);
	}
}