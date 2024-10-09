package com.haruns.basgeckart.repository;

import com.haruns.basgeckart.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card,Long> {
	
	Optional<Card> findByCardNumber(String cardNumber);
}