package com.bappi.ecommercebackend.dto.response;

import lombok.Builder;

@Builder
public record UserCreatedResponseDto (
    String name,
    String email,
    String message
){}
