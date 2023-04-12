package com.design.userservice.mapper;


import com.design.dtoservice.user_service.UserDto;
import com.design.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = "spring")
public interface UserMapper {

    UserDto entityToDto(User user);

    User dtoToEntity(UserDto userDto);
}
