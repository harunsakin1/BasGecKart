package com.haruns.basgeckart.controller;

import com.haruns.basgeckart.dto.request.CreateSpecialCardRequestDto;
import com.haruns.basgeckart.entity.Card;
import com.haruns.basgeckart.service.CardService;
import com.haruns.basgeckart.utility.CardNumberGenerator;
import com.haruns.basgeckart.utility.enums.CardType;
import com.haruns.basgeckart.utility.enums.PaymentType;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.haruns.basgeckart.constants.RestApis.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(CARD)
public class CardController {
	private final CardService cardService;
	private CardNumberGenerator dataGenerator = new CardNumberGenerator();
	@GetMapping(ADD_ALL_CARDS)
	public String addAllCards() {
		Card card = Card.builder()
		                .cardNumber(dataGenerator.generateCardNumber())
		                .cardType(CardType.HANDICAPPED)
		                .visaDate(LocalDate.now().plusYears(2))
		                .build();
		
		Card card1 = Card.builder()
		                 .cardNumber(dataGenerator.generateCardNumber())
		                 .cardType(CardType.STUDENT)
		                 .visaDate(LocalDate.now().plusYears(1))
		                 .build();
		
		Card card2 = Card.builder()
		                 .cardNumber(dataGenerator.generateCardNumber())
		                 .cardType(CardType.STANDARD)
		                 .visaDate(LocalDate.now().plusYears(99))
		                 .build();
		
		Card card3 = Card.builder()
		                 .cardNumber(dataGenerator.generateCardNumber())
		                 .cardType(CardType.TEACHER)
		                 .visaDate(LocalDate.now().plusYears(2))
		                 .build();
		
		cardService.addAllCard(List.of(card, card1, card2, card3));
		return "Kayıtlar başarıyla eklendi";
	}
	@PostMapping(CREATE_ANONYMOUS_CARD)
	public Card createAnonymousCard(){
		return cardService.createAnonymousCard();
	}
	@PostMapping(CREATE_SPECIAL_CARD)
	public Card specialCard(@RequestBody @Valid CreateSpecialCardRequestDto dto){
		return cardService.specialCard(dto);
	}
	
	
}