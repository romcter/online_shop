package com.design.productservice.mapper;

import com.design.dtoservice.product_service.ProductDto;
import com.design.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface ProductMapper {

    ProductDto entityToDto(Product address);

    Product dtoToEntity(ProductDto addressDTO);
}
