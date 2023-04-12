package com.design.productservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractBaseEntity {

    private String description;

    private Double price;
}
