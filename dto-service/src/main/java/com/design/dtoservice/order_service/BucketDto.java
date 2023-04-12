package com.design.dtoservice.order_service;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
public class BucketDto {

    @Schema(name= "id" , description = "bucket id", example = "1321")
    private Long id;

    @Schema(name= "user_id" , description = "user id assigned to this bucket", example = "1321")
    private Long userId;

    @Schema(name= "list_product_id" , description = "product id that added to this bucket", example = "[1321, 124,662]")
    private List<Long> listProductId;
}
