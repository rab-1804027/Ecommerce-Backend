package com.bappi.ecommercebackend.controller;

import com.bappi.ecommercebackend.dto.LoginRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Operation(summary = "Login a User", description = "Login a user with email and username")
    @ApiResponse()
    @PostMapping("/login")
    public ResponseEntity<?> login(@Parameter(name = "login info", required = true)
                                   @RequestBody @Valid LoginRequestDto loginRequestDto){



        return null;
    }
}
