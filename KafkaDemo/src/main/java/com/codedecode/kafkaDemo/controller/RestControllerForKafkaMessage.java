package com.codedecode.kafkaDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api")
public class RestControllerForKafkaMessage {

	@GetMapping("/producerMsg")
	public void getMessageFromClient(@RequestParam("message") String message) {
		
	}
}
