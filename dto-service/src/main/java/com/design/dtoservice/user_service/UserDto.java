package com.design.dtoservice.user_service;

//import lombok.*;
//
import java.util.List;
//
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class UserDto {

//    @NonNull
    private Long id;

    private String name;

    private List<Long> productIds;

    public UserDto(Long id, String name, List<Long> productIds) {
        this.id = id;
        this.name = name;
        this.productIds = productIds;
    }
}
