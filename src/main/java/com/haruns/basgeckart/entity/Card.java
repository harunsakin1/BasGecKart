package com.haruns.basgeckart.entity;

import com.haruns.basgeckart.utility.enums.CardType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblcard")
public class Card extends BaseEntity{
	
	@Column(unique = true, nullable = false)
	String cardNumber;
	CardType cardType;
	@Builder.Default
	Double balance = 0.0;
	LocalDate visaDate;
	LocalDateTime lastUsed;
	
	
}