package com.design.productservice.mapper;

import com.design.dtoservice.product_service.ProductDto;
import com.design.dtoservice.product_service.ProductWithIdDto;
import com.design.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface ProductMapper {

    ProductDto entityToDto(Product product);

    Product dtoToEntity(ProductDto productDTO);

    Product dtoToEntity(ProductWithIdDto productDTO);

    ProductWithIdDto entityToDtoWithId(Product product);

    List<ProductDto> entitysToDtos(List<Product> products);

    List<Product> dtosToEntitys(List<ProductDto> productsDTO);
}
