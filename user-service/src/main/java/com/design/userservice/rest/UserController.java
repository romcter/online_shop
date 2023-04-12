package com.design.userservice.rest;

import com.design.dtoservice.user_service.UserDto;
import com.design.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Tag(name = "User API")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by id")
    public ResponseEntity<UserDto> getUser(@PathVariable  Long id) {
        UserDto foundUser = userService.findById(id);
        log.info("Found user {}", foundUser);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Create new user")
    public ResponseEntity<UserDto> postUser(@RequestBody UserDto user) {
        UserDto savedUser = userService.save(user);
        log.info("Saved user {}", savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete user by id")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
