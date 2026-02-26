package com.bappi.ecommercebackend.config.security;

import com.bappi.ecommercebackend.service.security.JwtTokenService;
import com.bappi.ecommercebackend.util.Constants;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestTokenHeader = request.getHeader(Constants.JwtConstant.JWT_HEADER);

        String email = null;
        String token = null;

        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            token = requestTokenHeader.substring(7);
            try{
                email = jwtTokenService.getEmailFromToken(token);
                log.debug("email: {}",email);
            }catch(IllegalArgumentException | ExpiredJwtException e){
                log.error("{}",e.getMessage());
            }
        }else{
            log.debug("JWT token does not start with bearer");
        }

        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            boolean isTokenValid = false;
            try{
                isTokenValid = jwtTokenService.validateToken(token, userDetails);
            }catch (Exception e){
                log.error("Exception in auth");
            }
            if(isTokenValid){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,
                                                                                                                        null,
                                                                                                                                  userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
