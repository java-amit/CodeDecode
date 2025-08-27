package com.codedecode.StrategyDesignPattern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.StrategyDesignPattern.enums.EncodingPatternEnum;
import com.codedecode.StrategyDesignPattern.factory.EncryptionFactory;

@RestController
public class DemoController {
	
	@Autowired
	EncryptionFactory factory;
	
	@GetMapping("/encrypt")
	public void encryptWithEncoder(@RequestParam EncodingPatternEnum encodingPatternEnum) {
		factory.findEncryptionType(encodingPatternEnum).encrypt("code decode");
	}

}
