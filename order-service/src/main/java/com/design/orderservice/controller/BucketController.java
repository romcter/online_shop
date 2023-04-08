package com.design.orderservice.controller;

import com.design.orderservice.service.BucketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bucket")
public class BucketController {

    private final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @PostMapping("/product")
    public ResponseEntity<HttpStatus> addProduct(@RequestParam Long bucketId, @RequestParam Long productId){
        bucketService.addProduct(bucketId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public ResponseEntity<HttpStatus> deleteProduct(@RequestParam Long bucketId, @RequestParam Long productId){
        bucketService.deleteProduct(bucketId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
