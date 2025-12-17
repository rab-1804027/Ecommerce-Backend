package com.bappi.ecommercebackend.controller;

import com.bappi.ecommercebackend.dto.UserCreateRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Operation(summary = "Create User", description = "Create a user depending upon user information")
    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequestDto userCreateRequestDto){

        return null;
    }
}
