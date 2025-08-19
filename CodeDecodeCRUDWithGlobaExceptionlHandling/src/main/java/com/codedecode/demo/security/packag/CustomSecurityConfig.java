package com.codedecode.demo.security.packag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/code/user").hasRole("USER") // only ADMIN can access
                .requestMatchers("/code/admin").hasRole("ADMIN") // only ADMIN can access
                .requestMatchers("/").permitAll()
                .anyRequest().authenticated()                   // all other requests require login
            )
            .formLogin() // enable form-based login
            .and()
            .httpBasic(); // (optional) enable basic auth

        return http.build();
    }
	
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
