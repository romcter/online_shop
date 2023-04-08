package com.design.orderservice.mapper;

import com.design.dtoservice.order_service.BucketDto;
import com.design.orderservice.entity.Bucket;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface BucketMapper {

    BucketDto entityToDto(Bucket bucket);

    Bucket dtoToEntity(BucketDto bucketDTO);
}
