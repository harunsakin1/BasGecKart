package com.haruns.basgeckart.service;

import com.haruns.basgeckart.dto.request.UseCardRequestDto;
import com.haruns.basgeckart.entity.Card;
import com.haruns.basgeckart.entity.Expense;
import com.haruns.basgeckart.entity.Transport;
import com.haruns.basgeckart.mapper.ExpenseMapper;
import com.haruns.basgeckart.repository.ExpenseRepository;
import com.haruns.basgeckart.utility.TimeConverter;
import com.haruns.basgeckart.exception.CardException;
import com.haruns.basgeckart.exception.ErrorType;
import com.haruns.basgeckart.exception.TransportException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
		Expense expMapper= ExpenseMapper.INSTANCE.fromUseCardRequestDto(dto);
		Optional<Card> optCard = cardService.findCardById(expMapper.getCardId());
		if (optCard.isEmpty()){
			throw new CardException(ErrorType.CARD_NOT_FOUND);
		}
		Optional<Transport> optTransport = transportService.findTransportById(expMapper.getTransportId());
		if(optTransport.isEmpty()){
			throw new TransportException(ErrorType.TRANSPORT_NOT_FOUND);
		}
			Card card=optCard.get();
			Transport transport=optTransport.get();
			Double amount = card.getCardType().getDiscountRate()*transport.getTransportType().getPrice();
			if (card.getBalance()<(amount*CHANGE_TRANSPORT_DISCOUNT_RATE)){
				return "Yetersiz Bakiye!";
			}
			else if (card.getBalance()>= amount) {
				if (isChangeTransport(expMapper.getCardId())) {
					card.setBalance(card.getBalance()-(amount*CHANGE_TRANSPORT_DISCOUNT_RATE));
					cardService.saveCard(card);
					Expense expense=
							Expense.builder().expenseDate(System.currentTimeMillis()).amount(amount*CHANGE_TRANSPORT_DISCOUNT_RATE).cardId(expMapper.getCardId()).transportId(expMapper.getTransportId()).build();
					expenseRepository.save(expense);
					return "Kalan bakiye : "+card.getBalance();
				}
				else {
					card.setBalance(card.getBalance()-(amount));
					cardService.saveCard(card);
					Expense expense=
							Expense.builder().expenseDate(System.currentTimeMillis()).amount(amount).cardId(expMapper.getCardId()).transportId(expMapper.getTransportId()).build();
					expenseRepository.save(expense);
					return "Kalan bakiye : "+card.getBalance();
				}
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