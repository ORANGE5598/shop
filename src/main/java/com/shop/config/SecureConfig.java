package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecureConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeHttpRequests((auth) -> {
			auth.antMatchers("/index").permitAll();
			auth.antMatchers("/mypage/**", "/edit/**", "/cart/**", "/orders/**").authenticated();
		});
		
		http.formLogin()
			.loginPage("/signin")
			.loginProcessingUrl("/signin")
			.defaultSuccessUrl("/");
		
		http.logout().deleteCookies("JSESSIONID");
		
		return http.build();
	}
}
