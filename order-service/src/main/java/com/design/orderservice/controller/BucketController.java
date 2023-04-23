package com.design.orderservice.controller;

import com.design.dtoservice.order_service.bucket.ChangeBucket;
import com.design.orderservice.service.BucketService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Bucket API")
@RequestMapping("/bucket")
public class BucketController {

    private final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @PostMapping("/product")
    public ResponseEntity<Long> createAndAssignBucketToUser(@RequestBody Long userId){
        return new ResponseEntity<>(bucketService.createAndAssignBucketToUser(userId), HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody ChangeBucket changeBucket){
        bucketService.addProduct(changeBucket);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public ResponseEntity<HttpStatus> deleteProduct(@RequestBody ChangeBucket changeBucket){
        bucketService.deleteProduct(changeBucket);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
