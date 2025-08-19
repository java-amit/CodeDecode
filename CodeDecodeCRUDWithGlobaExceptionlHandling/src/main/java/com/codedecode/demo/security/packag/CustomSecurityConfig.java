package com.codedecode.demo.security.packag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {
	
	@Bean  
	public UserDetailsService userDetailsService () {
		UserDetails user1 = User
				.withDefaultPasswordEncoder()
				.username("user")
				.password("pass")
				.roles("USER")
				.build();
		UserDetails user2 = User
				.withDefaultPasswordEncoder()
				.username("harsh")
				.password("h@123")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}
	

}
