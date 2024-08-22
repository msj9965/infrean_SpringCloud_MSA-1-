package com.example.user_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurity{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/user-service/**").permitAll() // "/users/**" 경로에 대한 접근을 허용

                )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable()) // 새로운 방식으로 X-Frame-Options 헤더 비활성화
                );

        return http.build();

    }
}
