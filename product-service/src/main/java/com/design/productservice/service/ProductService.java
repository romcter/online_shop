package com.design.productservice.service;

import com.design.dtoservice.product_service.ProductDto;
import com.design.dtoservice.product_service.ProductWithIdDto;
import com.design.productservice.entity.Product;
import com.design.productservice.mapper.ProductMapper;
import com.design.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto findById(Long id){
        return productMapper.entityToDto(productRepository.findById(id).orElseThrow());
    }

    public List<ProductDto> findAll(){
        return productMapper.entitysToDtos(productRepository.findAll());
    }

    public ProductDto save(ProductDto productDto){
        Product product = productMapper.dtoToEntity(productDto);
        product = productRepository.save(product);
        return  productMapper.entityToDto(product);
    }

    public ProductWithIdDto update(ProductWithIdDto productDto){
        Product product = productMapper.dtoToEntity(productDto);
        product = productRepository.save(product);
        return productMapper.entityToDtoWithId(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
