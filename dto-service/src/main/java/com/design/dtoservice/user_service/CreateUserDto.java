package com.design.dtoservice.user_service;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

    @Schema(name= "name" , description = "User name", example = "Jon Doe")
    private String name;
}
