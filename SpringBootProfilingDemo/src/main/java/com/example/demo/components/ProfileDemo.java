package com.example.demo.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("prod")
public class ProfileDemo {
	
	@Value("${message}")
	String message;
	
	@Value("${prodSpecificKey}")
	String prodSpecificMessage;
	
	@Value("${spring.profiles.active}")
	String activeProfilee;
	
	@PostConstruct
	public void printMessage() {
		System.out.println("Message is "+ message);
		System.out.println("From prod profile "+ prodSpecificMessage);
		System.out.println("Active Profile is :: "+ activeProfilee);
	}

}
