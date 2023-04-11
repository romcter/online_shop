package com.design.dtoservice.user_service;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UserDto {

    @NonNull
    @Schema(name= "Id" , description = "User id", example = "1")
    private Long id;

    @Schema(name= "name" , description = "User name", example ="Kostia")
    private String name;

    @Schema(name= "productIds", description = "Array of user products", example = "\"productIds\": [ 1 ,2 ,3 ]")
    private List<Long> productIds;
}
