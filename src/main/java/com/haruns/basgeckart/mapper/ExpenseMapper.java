package com.haruns.basgeckart.mapper;

import com.haruns.basgeckart.dto.request.UseCardRequestDto;
import com.haruns.basgeckart.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExpenseMapper {
	ExpenseMapper INSTANCE= Mappers.getMapper(ExpenseMapper.class);
	
	Expense fromUseCardRequestDto(final UseCardRequestDto dto);
}