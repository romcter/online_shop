package com.design.userservice.rest;

import com.design.dtoservice.user_service.UserDto;
import com.design.userservice.entity.User;
import com.design.userservice.service.UserService;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Operation(summary = "Get a User by id", description = "Returns a User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found -  User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable @Parameter(name = " User id", example = "1") Long id) {
        UserDto foundUser = userService.findById(id);
        log.info("Found user {}", foundUser);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }

    @Operation(summary = "Create new User", description = "Create a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "500", description = "Error -  User has not been created ")})
    @PostMapping("/")
    public ResponseEntity<UserDto> postUser(@RequestBody @Parameter(name = "user",
            example = "id: 0," +
            " name: string," +
            " productIds : [0]") User user) {
        UserDto savedUser = userService.save(user);
        log.info("Saved user {}", savedUser);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @Operation(summary = "Delete User", description = "Delete a by user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "404", description = "Not found -  User not found")})
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable @Parameter(name = "User id", example = "1") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
