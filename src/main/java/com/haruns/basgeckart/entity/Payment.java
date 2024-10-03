package com.haruns.basgeckart.entity;

import com.haruns.basgeckart.utility.enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblpayment")
public class Payment extends BaseEntity {
	PaymentType paymentType;
	Long cardNumber;
	Double balance;
	Long passengerId;
	
}