package com.haruns.basgeckart.entity;

import com.haruns.basgeckart.utility.enums.TransportType;
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
@Table(name = "tbltransport")
public class Transport extends BaseEntity {
    TransportType transportType;
	Double price;
}