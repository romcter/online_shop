package com.design.dtoservice.order_service;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;

    private Long userId;

    private List<Long> listProductId;
}
