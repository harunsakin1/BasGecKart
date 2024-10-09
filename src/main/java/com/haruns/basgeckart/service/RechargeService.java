package com.haruns.basgeckart.service;

import com.haruns.basgeckart.dto.request.AddBalanceRequestDto;
import com.haruns.basgeckart.entity.Card;
import com.haruns.basgeckart.entity.Recharge;
import com.haruns.basgeckart.repository.RechargeRepository;
import com.haruns.basgeckart.utility.enums.PaymentType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RechargeService {
	RechargeRepository rechargeRepository;
	CardService cardService;
	
	public void addRecharge(AddBalanceRequestDto dto) {
		Recharge recharge = Recharge.builder()
		                            .cardNumber(dto.getCardNumber())
		                            .rechargeDate(LocalDateTime.now())
		                            .amount(dto.getAmount())
		                            .paymentType(dto.getPaymentType())
		                            .build();
		rechargeRepository.save(recharge);
	}
	
	public void addBalance(AddBalanceRequestDto dto) {
		Optional<Card> optCard = cardService.findCardByNumber(dto.getCardNumber());
		if (optCard.isPresent()) {
			Card card = optCard.get();
			card.setBalance(card.getBalance() + dto.getAmount());
			addRecharge(dto);
			cardService.saveCard(card);
		}
	}
}