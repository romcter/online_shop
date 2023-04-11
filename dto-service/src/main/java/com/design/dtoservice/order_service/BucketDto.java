package com.design.dtoservice.order_service;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(name= "Id" , description = "Bucket id", example = "1")
    private Long id;

    private Long userId;

    private List<Long> listProductId;
}
