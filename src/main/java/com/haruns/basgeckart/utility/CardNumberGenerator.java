package com.haruns.basgeckart.utility;

import com.haruns.basgeckart.controller.CardController;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component

public class CardNumberGenerator implements ApplicationRunner {
	public CardNumberGenerator() {
	}
	
	@PostConstruct
	public void generateData(){
		System.out.println("Merhaba dünya");
	}
	
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	
	
	}
	
	public String generateCardNumber() {
		Random random = new Random();
		int[] cardNumber = new int[16];
		
		// İlk 15 basamağı rastgele doldur
		for (int i = 0; i < 15; i++) {
			cardNumber[i] = random.nextInt(10);
		}
		
		// Son basamağı (Luhn algoritmasına uygun olacak şekilde) hesapla
		int checkDigit = calculateLuhnCheckDigit(cardNumber);
		cardNumber[15] = checkDigit;
		
		// Kart numarasını string'e dönüştür
		StringBuilder cardNumberStr = new StringBuilder();
		for (int digit : cardNumber) {
			cardNumberStr.append(digit);
		}
		
		return cardNumberStr.toString();
		
	}
	
	// Luhn algoritmasına uygun son basamak hesaplama
	public static int calculateLuhnCheckDigit(int[] cardNumber) {
		int sum = 0;
		boolean doubleDigit = true;
		
		// Sağdan sola doğru Luhn toplamını hesapla (son basamağı hariç)
		for (int i = cardNumber.length - 2; i >= 0; i--) {
			int digit = cardNumber[i];
			if (doubleDigit) {
				digit *= 2;
				if (digit > 9) {
					digit -= 9;
				}
			}
			sum += digit;
			doubleDigit = !doubleDigit;
		}
		// Toplamın son basamağını kontrol ederek doğrulama rakamını bul
		int checkDigit = (10 - (sum % 10)) % 10;
		return checkDigit;
	}
	
	public Boolean isValidCardNumber(String cardNumber) {
		int total = 0;
		boolean doubleDigit = false;
		for (int i = cardNumber.length()-1; i >=0 ; i--) {
			int numericValue = Character.getNumericValue(cardNumber.charAt(i));
			if (doubleDigit) {
				numericValue *= 2;
				if (numericValue > 9) {
					numericValue -= 9;
				}
			}
			total += numericValue;
			doubleDigit = !doubleDigit;
		}
		return (total % 10 == 0);
	}
	
}