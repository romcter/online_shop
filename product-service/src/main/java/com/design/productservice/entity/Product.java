package com.design.productservice.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractBaseEntity {

    private String description;

    private Double price;
}
