package com.design.dtoservice.order_service;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
public class OrderDto {

    @Schema(name= "Id" , description = "Order id", example = "1")
    private Long id;

    private Long userId;

    private List<Long> listProductId;
}
