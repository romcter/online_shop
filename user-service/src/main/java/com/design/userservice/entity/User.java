package com.design.userservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractBaseEntity {

    private String name;

    @ElementCollection
    private List<Long> productIds;

    private Long bucketId;
}
