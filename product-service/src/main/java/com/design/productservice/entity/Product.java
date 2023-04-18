package com.design.productservice.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Product extends AbstractBaseEntity {

    private String description;

    private Double price;

    private List<String> photoId = new ArrayList<>();
}
