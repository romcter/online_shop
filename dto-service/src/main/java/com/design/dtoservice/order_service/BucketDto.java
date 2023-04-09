package com.design.dtoservice.order_service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BucketDto {

    private Long id;

    private Long userId;

    private List<Long> listProductId;
}
