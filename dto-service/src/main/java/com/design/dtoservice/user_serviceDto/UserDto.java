package com.design.dtoservice.user_serviceDto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NonNull
    private Long id;

    private String name;

    private List<Long> productIds;
}
