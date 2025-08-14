package com.code.decode.SpringBootExample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeDecodeController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@GetMapping("/codeDecode")
	public void codeDecodeGetMethod() {
		System.out.println("my server port is "+serverPort);
	}

}
