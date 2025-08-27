package com.codedecode.StrategyDesignPattern.encrpt;

import org.springframework.stereotype.Service;

import com.codedecode.StrategyDesignPattern.enums.EncodingPatternEnum;

@Service
public class SHA2Encryption implements Encryption{

	@Override
	public void encrypt(String toBeEncrypted) {  
		System.out.println("I am encrypting using SHA2 Encryption Method");
	}

	@Override
	public EncodingPatternEnum getEncryptionType() {
		return EncodingPatternEnum.SHA2;
	}

}
