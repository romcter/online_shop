package com.design.productservice.controller;

import com.design.dtoservice.product_service.ProductDto;
import com.design.dtoservice.product_service.ProductWithIdDto;
import com.design.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Product API")
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Product by id", description = "Returns a Product by id")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Create new Product", description = "Create a Product")
    public ResponseEntity<ProductDto> postProduct(@RequestBody ProductDto productDto) {
        ProductDto savedProduct = productService.save(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @PutMapping("/")
    @Operation(summary = "Update existing product", description = "Update product")
    public ResponseEntity<ProductWithIdDto> updateProduct(@RequestBody ProductWithIdDto productDto) {
        ProductWithIdDto savedProduct = productService.update(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all products", description = "Returns all products")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
}
