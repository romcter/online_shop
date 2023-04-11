package com.design.dtoservice.product_service;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ProductDto {

    @NonNull
    @Schema(name= "Id" , description = "Product id", example = "1")
    private Long id;
    @Schema(name= "Description" , description = "Description for product", example ="Here will be a text with a description ")
    private String description;
    @Schema(name= "Price" , description = "Price for product", example ="100.00")
    private Double price;
}
