package com.design.dtoservice.user_service;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class UserDto {

    @NonNull
    private Long id;

    private String name;

    private List<Long> productIds;
}
