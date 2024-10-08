package com.haruns.basgeckart.entity;

import com.haruns.basgeckart.utility.enums.PaymentType;
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
@Table(name = "tblrecharge")
public class Recharge extends BaseEntity {
	
	Long cardId;
	PaymentType paymentType;
	Double amount;
	LocalDateTime rechargeDate;
	
}