package com.design.orderservice.service;

import com.design.dtoservice.order_service.BucketDto;
import com.design.orderservice.entity.Bucket;
import com.design.orderservice.mapper.BucketMapper;
import com.design.orderservice.repository.BucketRepository;
import org.springframework.stereotype.Service;

@Service
public class BucketService {

    private final BucketRepository bucketRepository;
    private final BucketMapper bucketMapper;

    public BucketService(BucketRepository bucketRepository, BucketMapper bucketMapper) {
        this.bucketRepository = bucketRepository;
        this.bucketMapper = bucketMapper;
    }

    public BucketDto getById(Long id){
        return bucketMapper.entityToDto(bucketRepository.findById(id).orElseThrow());
    }

    public Long createAndAssignBucketToUser(Long userId){
        Bucket bucket = Bucket
                .builder()
                .userId(userId)
                .build();

        return bucketRepository.save(bucket).getId();
    }

    public void addProduct(Long bucketId, Long productId){
        bucketRepository.findById(bucketId)
                .orElseThrow()
                .getProductIds()
                .add(productId);
    }

    public void deleteProduct(Long bucketId, Long productId){
        bucketRepository.findById(bucketId)
                .orElseThrow()
                .getProductIds()
                .remove(productId);
    }
}
