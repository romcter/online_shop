package com.design.productservice.entity;


import javax.persistence.Entity;
import io.swagger.v3.oas.annotations.media.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbstractBaseEntity {

    @Schema(name= "Description" , description = "Description for product", example ="Here will be a text with a description ")
    private String description;
    @Schema(name= "Price" , description = "Price for product", example ="100.00")
    private Double price;
}
