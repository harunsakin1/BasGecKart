package com.haruns.basgeckart.service.proxy;

import com.haruns.basgeckart.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CardServiceProxy {
	private final ApplicationContext context;
	
	
	public CardService getCardService() {
		return context.getBean(CardService.class);
	}
	
}