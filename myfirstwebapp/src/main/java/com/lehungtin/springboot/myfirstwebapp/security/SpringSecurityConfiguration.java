package com.lehungtin.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = createUser("admin", "admin");
		UserDetails userDetails2 = createUser("johan", "johan");
		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails createUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
	            auth -> auth.anyRequest().authenticated())
	        .formLogin(withDefaults());

	    http.csrf(AbstractHttpConfigurer::disable);
	    http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
		
		return http.build();
		
	}
}
