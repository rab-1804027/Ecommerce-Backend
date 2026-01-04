package com.bappi.ecommercebackend.mapper;

import com.bappi.ecommercebackend.dto.UserCreateRequestDto;
import com.bappi.ecommercebackend.entity.User;
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

}
