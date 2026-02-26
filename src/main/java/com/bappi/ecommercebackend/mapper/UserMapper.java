package com.bappi.ecommercebackend.mapper;

import com.bappi.ecommercebackend.dto.UserCreateRequestDto;
import com.bappi.ecommercebackend.dto.response.UserCreatedResponseDto;
import com.bappi.ecommercebackend.entity.User;
import com.bappi.ecommercebackend.util.Constants;
import com.bappi.ecommercebackend.util.TimeUtils;

public class UserMapper {

    public static User toEntity(UserCreateRequestDto userCreateRequestDto){
        return User.builder()
                .firstName(userCreateRequestDto.firstName())
                .lastName(userCreateRequestDto.lastName())
                .email(userCreateRequestDto.email())
                .password(userCreateRequestDto.password())
                .createdAt(TimeUtils.createTime())
                .build();
    }

    public static UserCreatedResponseDto toUserCreateResponseDto(UserCreateRequestDto userCreateRequestDto){
        return UserCreatedResponseDto.builder()
                .name(userCreateRequestDto.firstName()+ " "+ userCreateRequestDto.lastName())
                .email(userCreateRequestDto.email())
                .message(Constants.Message.USER_CREATE_RESPONSE_MESSAGE)
                .build();
    }

}
