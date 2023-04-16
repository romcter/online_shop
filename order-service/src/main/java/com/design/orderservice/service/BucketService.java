package com.design.orderservice.service;

import com.design.dtoservice.order_service.BucketDto;
import com.design.orderservice.entity.Bucket;
import com.design.orderservice.mapper.BucketMapper;
import com.design.orderservice.repository.BucketRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
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

    @KafkaListener(topics = "name", groupId = "groupId")
    public String createAndAssignBucketToUser(final ConsumerRecord<String, Dto> consumerRecord){
//        Bucket bucket = Bucket
//                .builder()
//                .userId(Long.parseLong(userId))
//                .build();

        System.out.println("===================================================================================== 🥰 " + consumerRecord.value());

        return consumerRecord.toString();
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
