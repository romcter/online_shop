package com.design.dtoservice.user_service;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.List;

@Data
public class UserDto {

    @Schema(name= "Id" , description = "User id", example = "1")
    private Long id;

    @Schema(name= "name" , description = "User name", example ="Kostia")
    private String name;

    @Schema(name= "product_ids", description = "Array of user's products", example = "\"productIds\": [ 1 ,2 ,3 ]")
    private List<Long> productIds;
}
