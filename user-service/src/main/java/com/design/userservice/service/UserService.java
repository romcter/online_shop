package com.design.userservice.service;

import com.design.dtoservice.user_service.UserDto;
import com.design.userservice.entity.User;
import com.design.userservice.mapper.UserMapper;
import com.design.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableScheduling
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

    @Scheduled(fixedRate = 1000)
    public void scheduler1(){
        log.info("Scheduler 1000");
    }

    @Scheduled(fixedRate = 5000)
    public void scheduler2(){
        log.info("Scheduler 5000");
    }
}
