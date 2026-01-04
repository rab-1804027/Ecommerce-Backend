package com.bappi.ecommercebackend.service;

import com.bappi.ecommercebackend.dto.UserCreateRequestDto;
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

    public User save(UserCreateRequestDto userCreateRequestDto){

        User user = UserMapper.toEntity(userCreateRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

}
