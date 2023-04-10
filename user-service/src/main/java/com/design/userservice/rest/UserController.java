package com.design.userservice.rest;

import com.design.dtoservice.user_service.UserDto;
import com.design.userservice.entity.User;
import com.design.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser( @PathVariable String  id) {

        UserDto foundUser = userService.findById(Long.parseLong(id));
        log.info("Found user {}", foundUser);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @PostMapping("/")
    @Operation(summary = "Get users", description = "Get list of users")
    public ResponseEntity<UserDto> postUser(@RequestBody User user) {
        UserDto savedUser = userService.save(user);
        log.info("Saved user {}", savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
