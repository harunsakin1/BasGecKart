package com.haruns.basgeckart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblexpense")
public class Expense extends BaseEntity {
	
	Long cardId;
	Double amount;
	LocalDateTime expenseDate;
	Long transportId;
	
}