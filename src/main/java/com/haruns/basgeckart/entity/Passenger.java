package com.haruns.basgeckart.entity;

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
	String tc;
	LocalDate birthDate;
	String phone;
	String email;
	String avatar;
	String password;
	String address;
}