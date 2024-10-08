package com.haruns.basgeckart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "tblpassenger")
public class Passenger extends BaseEntity {
	String name;
	String surname;
	@Column(unique = true)
	String tc;
	LocalDate birthDate;
	Long cardId;
	@Column(unique = true)
	String phone;
	@Column(unique = true)
	String email;
	String avatar;
	//	String password;  buna gerek yok, kart no gir para yükle şeklinde olacak
	String address;
	
	//TODO belge istenecek(ögr,gazi vb.)
}