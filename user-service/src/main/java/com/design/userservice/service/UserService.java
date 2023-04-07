package com.design.userservice.service;

import com.design.dtoservice.user_serviceDto.UserDto;
import com.design.userservice.entity.User;
import com.design.userservice.mapper.UserMapper;
import com.design.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;

        this.userMapper = userMapper;
    }

    public UserDto findById(Long id){
        return userMapper.entityToDto(userRepository.findById(id).orElseThrow());
    }

    public UserDto save(User user){
        return userMapper.entityToDto(userRepository.save(user));
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
