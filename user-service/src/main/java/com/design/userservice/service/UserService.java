package com.design.userservice.service;

import com.design.dtoservice.user_service.CreateUserDto;
import com.design.dtoservice.user_service.UserDto;
import com.design.userservice.entity.User;
import com.design.userservice.mapper.UserMapper;
import com.design.userservice.repository.UserRepository;
import com.design.userservice.rest.feignClient.OrderClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@EnableScheduling
public class UserService {

    private final UserMapper userMapper;
    private final OrderClient orderClient;
    private final UserRepository userRepository;
    private final KafkaTemplate kafkaTemplate;

    public UserService(UserRepository userRepository, UserMapper userMapper, OrderClient orderClient, KafkaTemplate kafkaTemplate) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
        this.orderClient = orderClient;
        this.kafkaTemplate = kafkaTemplate;
    }

    public UserDto findById(Long id) {
        return userMapper.entityToDto(userRepository.findById(id).orElseThrow());
    }

    public UserDto createUser(CreateUserDto userDto) {
        User user = userRepository.save(userMapper.dtoToEntity(userDto));
        Long bucketId = orderClient.createAndAssignBucketToUser(user.getId());
        user.setBucketId(bucketId);
        return userMapper.entityToDto(userRepository.save(user));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Scheduled(fixedRate = 10000)
    public void appAlive() {
        log.info("\n It's scheduler and it's take opportunity just know about working application 🤓");
    }
}
