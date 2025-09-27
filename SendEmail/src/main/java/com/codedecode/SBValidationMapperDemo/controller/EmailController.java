package com.codedecode.SBValidationMapperDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.SBValidationMapperDemo.service.SendEmailService;

@RestController
public class EmailController {

	@Autowired
	private SendEmailService sendEmailService;
	
	@GetMapping("sendEmail")
	public String sendEmail() {
		sendEmailService.sendEmail("amitbh94@gmail.com", "Test Subject", "Test Body");
		return "Sent Sucessfully";
	}
}
