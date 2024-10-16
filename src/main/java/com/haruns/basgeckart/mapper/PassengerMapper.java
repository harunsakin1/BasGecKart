package com.haruns.basgeckart.mapper;

import com.haruns.basgeckart.dto.request.RegisterRequestDto;
import com.haruns.basgeckart.dto.request.UpdatePassengerProfileDto;
import com.haruns.basgeckart.entity.Passenger;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassengerMapper {
	PassengerMapper INSTANCE= Mappers.getMapper(PassengerMapper.class);
	
	Passenger fromRegisterRequestDto(final RegisterRequestDto dto);
	
	Passenger fromUpdatePassengerProfileDto(final UpdatePassengerProfileDto dto);
}