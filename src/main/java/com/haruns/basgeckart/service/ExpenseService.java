package com.haruns.basgeckart.service;

import com.haruns.basgeckart.dto.request.UseCardRequestDto;
import com.haruns.basgeckart.entity.Card;
import com.haruns.basgeckart.entity.Expense;
import com.haruns.basgeckart.entity.Transport;
import com.haruns.basgeckart.repository.ExpenseRepository;
import com.haruns.basgeckart.utility.TimeConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseService {
	ExpenseRepository expenseRepository;
	CardService cardService;
	TransportService transportService;
	private final double CHANGE_TRANSPORT_DISCOUNT_RATE = 0.3;
	
	public String useCard(UseCardRequestDto dto){
		Optional<Card> optCard = cardService.findCardById(dto.getCardId());
		Optional<Transport> optTransport = transportService.findTransportById(dto.getTransportId());
		if (optCard.isPresent()&& optTransport.isPresent()){
			Card card=optCard.get();
			Transport transport=optTransport.get();
			Double amount = card.getCardType().getDiscountRate()*transport.getTransportType().getPrice();
			if (card.getBalance()<(amount*CHANGE_TRANSPORT_DISCOUNT_RATE)){
				return "Yetersiz Bakiye!";
			}
			else if (card.getBalance()>= amount) {
				if (isChangeTransport(dto.getCardId())) {
					card.setBalance(card.getBalance()-(amount*CHANGE_TRANSPORT_DISCOUNT_RATE));
					cardService.saveCard(card);
					Expense expense=
							Expense.builder().expenseDate(System.currentTimeMillis()).amount(amount*CHANGE_TRANSPORT_DISCOUNT_RATE).cardId(dto.getCardId()).transportId(dto.getTransportId()).build();
					expenseRepository.save(expense);
					return "Kalan bakiye : "+card.getBalance();
				}
				else {
					card.setBalance(card.getBalance()-(amount));
					cardService.saveCard(card);
					Expense expense=
							Expense.builder().expenseDate(System.currentTimeMillis()).amount(amount).cardId(dto.getCardId()).transportId(dto.getTransportId()).build();
					expenseRepository.save(expense);
					return "Kalan bakiye : "+card.getBalance();
				}
			}
		}
		else {
			return "Kart ya da toplu taşıma aracı bulunamadı!";
		}
		return "";
	}
	
	public boolean isChangeTransport(Long cardId){
		List<Expense> expenseList = expenseRepository.findAllByCardId(cardId);
		
		Optional<Expense> optExpense = expenseList.stream().max(Comparator.comparing(Expense::getExpenseDate));
		if (optExpense.isPresent()){
			Expense expense=optExpense.get();
			Long minuteDifference = TimeConverter.epochToMinute(expense.getExpenseDate(), System.currentTimeMillis());
			if (minuteDifference>10 && minuteDifference<30){
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}