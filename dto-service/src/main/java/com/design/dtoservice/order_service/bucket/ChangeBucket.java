package com.design.dtoservice.order_service.bucket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeBucket {
    private Long bucketId;
    private List<Long> productIds;
}
