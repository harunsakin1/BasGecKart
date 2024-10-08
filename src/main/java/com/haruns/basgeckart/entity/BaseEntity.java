package com.haruns.basgeckart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Builder.Default
	Integer state=1;
	@Builder.Default
	LocalDateTime createdAt=LocalDateTime.now();
	@Builder.Default
	LocalDateTime updateAt=LocalDateTime.now();
}