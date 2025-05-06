package com.yosr.vetements.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .cors()  // Active le CORS
	            .and()
	            .csrf().disable() // Désactive CSRF pour permettre les appels Angular
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/vetements/api/**").permitAll() // Accessible sans login
	                .requestMatchers("/webjars/**", "/error").permitAll() // Accessibles aussi
	                .anyRequest().permitAll() // Permet toutes les autres requêtes
	            )
	            .formLogin().disable()  // Désactive le formulaire de connexion
	            .httpBasic().disable(); // Désactive la connexion HTTP basique

	        return http.build();
	    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
