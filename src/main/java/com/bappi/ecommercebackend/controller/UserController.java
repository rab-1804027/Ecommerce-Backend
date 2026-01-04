package com.bappi.ecommercebackend.controller;

import com.bappi.ecommercebackend.dto.UserCreateRequestDto;
import com.bappi.ecommercebackend.entity.User;
import com.bappi.ecommercebackend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create User", description = "Create a user depending upon user information")
    @ApiResponse()
    @PostMapping("/")
    public ResponseEntity<?> createUser(
            @Parameter(description = "userCreationRequest", required = true)
            @RequestBody @Valid UserCreateRequestDto userCreateRequestDto){

        User user = userService.save(userCreateRequestDto);
        return null;
    }
}
