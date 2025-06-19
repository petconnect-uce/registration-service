package com.petconnect.registration_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF (para APIs REST)
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll() // Permite todas las rutas sin autenticación
                );
        return http.build();
    }
}
