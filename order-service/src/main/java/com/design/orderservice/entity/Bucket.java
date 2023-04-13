package com.design.orderservice.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Bucket extends AbstractBaseEntity {

    private Long userId;

    @ElementCollection
    private List<Long> productIds;
}
