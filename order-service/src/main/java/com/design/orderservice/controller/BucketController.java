package com.design.orderservice.controller;

import com.design.orderservice.service.BucketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bucket")
public class BucketController {

    private final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @PostMapping("/add/product")
    public ResponseEntity<HttpStatus> addProduct(@RequestParam Long bucketId, @RequestParam Long productId){
        bucketService.addProduct(bucketId, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
