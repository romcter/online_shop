package com.design.dtoservice.orderDto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    @NonNull
    private Long id;

    private Long userId;
}
