package com.design.dtoservice.product_service;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @Schema(name= "id" , description = "product id", example = "1832")
    private Long id;

    @Schema(name= "description" , description = "product description", example = "This flower perfectly fit for your eyes")
    private String description;

    @Schema(name= "price" , description = "product price", example ="100.00")
    private Double price;
}
