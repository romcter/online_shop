package com.design.productservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(name= "Id" , description = "Product id", example = "1")
    private Long id;

    public AbstractBaseEntity(Long id) {
        this.id = id;
    }

    public AbstractBaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
