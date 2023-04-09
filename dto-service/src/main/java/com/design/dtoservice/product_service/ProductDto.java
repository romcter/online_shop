package com.design.dtoservice.product_service;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ProductDto {

    @NonNull
    private Long id;

    private String description;

    private Double price;
}
