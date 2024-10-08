package com.haruns.basgeckart.repository;

import com.haruns.basgeckart.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	public List<Expense> findAllByCardId(Long cardId);
}