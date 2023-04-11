package com.design.productservice.service;

import com.design.dtoservice.product_service.ProductDto;
import com.design.productservice.entity.Product;
import com.design.productservice.mapper.ProductMapper;
import com.design.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@EnableScheduling
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

    public ProductDto save(Product product){
        return productMapper.entityToDto(productRepository.save(product));
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    @Scheduled(fixedRate = 1000)
    public void scheduler1(){
        log.info("Scheduler 1000");
    }

    @Scheduled(fixedRate = 5000)
    public void scheduler2(){
        log.info("Scheduler 5000");
    }
}
