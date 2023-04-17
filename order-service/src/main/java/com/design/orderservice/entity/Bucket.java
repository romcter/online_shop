package com.design.orderservice.entity;

import jakarta.persistence.Entity;

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

    private List<Long> productIds;
}
