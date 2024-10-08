package com.haruns.basgeckart.service;

import com.haruns.basgeckart.dto.request.CreateSpecialCardRequestDto;
import com.haruns.basgeckart.entity.Card;
import com.haruns.basgeckart.entity.Passenger;
import com.haruns.basgeckart.repository.CardRepository;
import com.haruns.basgeckart.utility.CardNumberGenerator;
import com.haruns.basgeckart.utility.enums.CardType;
import com.haruns.basgeckart.utility.enums.PaymentType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CardService {
	private final CardRepository cardRepository;
	private final PassengerService passengerService;
	
	public void addAllCard(List<Card> cardList) {
		cardRepository.saveAll(cardList);
	}
	
	public Optional<Card> findCardById(Long cardId){
		return cardRepository.findById(cardId);
	}
	public void saveCard(Card card){
		cardRepository.save(card);
	}
	
	
	public Optional<Card> findCardByNumber(String cardNumber) {
		return cardRepository.findByCardNumber(cardNumber);
	}
	
	public Card createAnonymousCard(){
		return cardRepository.save(Card.builder()
		                        .cardNumber(CardNumberGenerator.generateCardNumber())
		                        .cardType(CardType.STANDARD)
				                .visaDate(CardType.STANDARD.getVisaDate())
		                        .build());
	}
	
	public Card specialCard(CreateSpecialCardRequestDto dto) {
		Passenger passenger = passengerService.findPassengerByTc(dto.getTc());
		if (validForElderCard(passenger, dto)) {
			return addCardAndSetToPassenger(dto, passenger);
		}
		else{
			dto.setCardType(CardType.STANDARD);
			return addCardAndSetToPassenger(dto, passenger);
		}
	}
	
	private Card addCardAndSetToPassenger(CreateSpecialCardRequestDto dto, Passenger passenger) {
		Card card = cardRepository.save(Card.builder().cardNumber(CardNumberGenerator.generateCardNumber())
		                                    .cardType(dto.getCardType()).visaDate(dto.getCardType().getVisaDate())
		                                    .build());
		
		passengerService.setCardToPassenger(card.getId(), passenger);
		return card;
	}
	
	public Boolean validForElderCard(Passenger passenger, CreateSpecialCardRequestDto dto){
		if (dto.getCardType().equals(CardType.ELDER)) {
			
			if (LocalDate.of(1960, 1, 1).isBefore(passenger.getBirthDate())) {
				return false;
			}
			return true;
		}
		return false;
	}
}