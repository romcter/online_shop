package com.design.productservice.service;

import com.design.dtoservice.product_service.ProductDto;
import com.design.dtoservice.product_service.ProductWithIdDto;
import com.design.productservice.entity.Product;
import com.design.productservice.mapper.ProductMapper;
import com.design.productservice.repository.ProductRepository;
import com.design.productservice.rest.client.MediaClient;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final MediaClient mediaServiceClient;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, MediaClient mediaServiceClient, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.mediaServiceClient = mediaServiceClient;
        this.productMapper = productMapper;
    }

    public ProductWithIdDto findById(Long id){
        return productMapper.entityToDtoWithId(productRepository.findById(id).orElseThrow());
    }

    public List<ProductDto> findAll(){
        return productMapper.entitysToDtos(productRepository.findAll());
    }

    @Transactional
    public ProductWithIdDto save(ProductDto productDto, MultipartFile image){
        Product product = productMapper.dtoToEntity(productDto);
        String photoId = mediaServiceClient.saveImage(image);
        product.getPhotoId().add(photoId);
        product = productRepository.save(product);
        return  productMapper.entityToDtoWithId(product);
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
