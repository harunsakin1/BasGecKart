package com.haruns.basgeckart.mapper;

import com.haruns.basgeckart.dto.request.CreateSpecialCardRequestDto;
import com.haruns.basgeckart.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CardMapper {
	CardMapper INSTANCE= Mappers.getMapper(CardMapper.class);
	
	
	Card fromCreateSpecialCardDto(final CreateSpecialCardRequestDto dto);
}