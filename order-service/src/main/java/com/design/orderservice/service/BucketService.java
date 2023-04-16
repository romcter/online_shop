package com.design.orderservice.service;

import lombok.extern.slf4j.Slf4j;
import com.design.orderservice.entity.Bucket;
import org.springframework.stereotype.Service;
import com.design.orderservice.mapper.BucketMapper;
import com.design.dtoservice.order_service.BucketDto;
import org.springframework.kafka.annotation.KafkaListener;
import com.design.orderservice.repository.BucketRepository;

@Slf4j
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

    @KafkaListener(topics = "${spring.kafka.name.order-service}")
    public Long createAndAssignBucketToUser(Long userId){

        Bucket bucket = Bucket
                .builder()
                .userId(userId)
                .build();

        bucket = bucketRepository.save(bucket);

        log.info("generated bucketId {} for userId {} 🥰 ", bucket.getId(), userId);

        return bucket.getId();
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
