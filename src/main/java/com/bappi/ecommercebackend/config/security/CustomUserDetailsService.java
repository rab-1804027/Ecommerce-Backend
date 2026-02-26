package com.bappi.ecommercebackend.config.security;

import com.bappi.ecommercebackend.entity.User;
import com.bappi.ecommercebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByEmail(username);
        if(user == null){
            throw new AuthenticationCredentialsNotFoundException("User not found");
        }
        
        return new CustomUserDetails(user);
    }
}
