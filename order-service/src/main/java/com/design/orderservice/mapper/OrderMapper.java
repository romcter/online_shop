package com.design.orderservice.mapper;

import com.design.dtoservice.order_service.OrderDto;
import com.design.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface OrderMapper {

    OrderDto entityToDto(Order order);

    Order dtoToEntity(OrderDto orderDTO);
}
