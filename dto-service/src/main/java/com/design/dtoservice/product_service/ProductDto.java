package com.design.dtoservice.product_service;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @Schema(name= "description" , description = "product description", example = "This flower perfectly fit for your eyes")
    private String description;

    @Schema(name= "price" , description = "product price", example ="100.00")
    private Double price;
}
