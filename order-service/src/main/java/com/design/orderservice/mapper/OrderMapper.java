package com.design.orderservice.mapper;

import com.design.dtoservice.orderDto.OrderDto;
import com.design.dtoservice.user_serviceDto.UserDto;
import com.design.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface OrderMapper {

    OrderDto entityToDto(Order address);

    Order dtoToEntity(OrderDto addressDTO);
}
