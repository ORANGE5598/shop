package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> {
			auth.antMatchers("/main").permitAll();
			auth.antMatchers("/main/admin").hasAnyRole("ADMIN");
		});
		
		http.csrf().disable();
		http.logout().deleteCookies("JSESSIONID");
		http.formLogin()
			.loginPage("/signin")
			.loginProcessingUrl("/signin")
			.defaultSuccessUrl("/main");
		
		return http.build();
	}
}
