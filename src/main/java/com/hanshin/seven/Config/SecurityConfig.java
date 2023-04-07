package com.hanshin.seven.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
//@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http
			.authorizeHttpRequests()
			.requestMatchers("/**").permitAll()
			;
		return http.build();
	}
}