package com.design.userservice.service;

import com.design.dtoservice.user_service.CreateUserDto;
import com.design.dtoservice.user_service.UserDto;
import com.design.userservice.entity.User;
import com.design.userservice.mapper.UserMapper;
import com.design.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@EnableScheduling
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final KafkaTemplate kafkaTemplate;

    public UserService(UserRepository userRepository, UserMapper userMapper, KafkaTemplate kafkaTemplate) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public UserDto findById(Long id) {
        return userMapper.entityToDto(userRepository.findById(id).orElseThrow());
    }

    public UserDto createUser(CreateUserDto userDto) {

        User user = userRepository.save(userMapper.dtoToEntity(userDto));

        //TODO implement functionality for send userId to order-server (bucket controller), create bucket and assign it to User (from user-service) by bucketId in User entity

        return userMapper.entityToDto(userRepository.save(user));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Scheduled(fixedRate = 10000)
    public void appAlive() {
        log.info("\n" + userRepository.findAll() + "🥹");
        log.info("\n It's scheduler and it's take opportunity just know about working application");
    }

    @Scheduled(fixedRate = 3000)
    public void kafkaMessage() {

        userRepository.save(new User("Van", List.of(1L, 13L), 1L));
        kafkaTemplate.send("order-service", 1L);
    }
}
