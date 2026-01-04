package com.bappi.ecommercebackend.dto;


import com.bappi.ecommercebackend.util.Constants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record UserCreateRequestDto(

        @NotBlank(message = "firstname is required")
        String firstName,

        @NotBlank(message = "lastname is required")
        String lastName,

        @Pattern(
                regexp = Constants.REGEX.PASSWORD_REGEX,
                message = "password must be at least 4character"
        )
        String password,

        @Pattern(
                regexp = Constants.REGEX.EMAIL_REGEX,
                message = "password must be at least 4character"
        )
        String confirmPassword,

        @Email(
                regexp = "^[A-Za-z0-9].%]+@[A-Za-z]+\\.[A-Za-z]{3,}$",
                message = "Email must be valid"
        )
        String email
){}
