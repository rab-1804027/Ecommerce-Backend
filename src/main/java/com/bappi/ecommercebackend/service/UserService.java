package com.bappi.ecommercebackend.service;

import com.bappi.ecommercebackend.dto.UserCreateRequestDto;
import com.bappi.ecommercebackend.dto.response.UserCreatedResponseDto;
import com.bappi.ecommercebackend.entity.User;
import com.bappi.ecommercebackend.mapper.UserMapper;
import com.bappi.ecommercebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserCreatedResponseDto save(UserCreateRequestDto userCreateRequestDto){

        User user = UserMapper.toEntity(userCreateRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);

        return UserMapper.toUserCreateResponseDto(userCreateRequestDto);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
