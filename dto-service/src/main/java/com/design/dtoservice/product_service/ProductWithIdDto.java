package com.design.dtoservice.product_service;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductWithIdDto {

    @Schema(name= "id" , description = "product id", example = "1832")
    private Long id;

    @Schema(name= "description" , description = "product description", example = "This flower perfectly fit for your eyes")
    private String description;

    @Schema(name= "price" , description = "product price", example ="100.00")
    private Double price;
}


