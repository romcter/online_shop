package com.design.productservice.service;

import com.design.productservice.entity.Product;
import com.design.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElseThrow();
    }

    public Product save(Product user){
        return productRepository.save(user);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }
}
