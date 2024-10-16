package com.haruns.basgeckart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CardServiceProxy {
	private final ApplicationContext context;
	
	
	private CardService getCardService() {
		return context.getBean(CardService.class);
	}
	
	public boolean existById(Long cardId){
		return getCardService().existById(cardId);
	}
	
}