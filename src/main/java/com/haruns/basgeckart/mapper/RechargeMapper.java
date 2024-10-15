package com.haruns.basgeckart.mapper;

import com.haruns.basgeckart.dto.request.AddBalanceRequestDto;
import com.haruns.basgeckart.entity.Recharge;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RechargeMapper {
	
	RechargeMapper INSTANCE= Mappers.getMapper(RechargeMapper.class);
	
	Recharge fromAddBalanceRequestDto(final AddBalanceRequestDto dto);
}