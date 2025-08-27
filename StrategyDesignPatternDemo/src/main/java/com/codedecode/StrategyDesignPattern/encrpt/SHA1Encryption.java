package com.codedecode.StrategyDesignPattern.encrpt;

import com.codedecode.StrategyDesignPattern.enums.EncodingPatternEnum;

public class SHA1Encryption implements Encryption{

	@Override
	public void encrypt(String toBeEncrypted) {  
		System.out.println("I am encrypting using SHA1 Encryption Method");
	}

	@Override
	public EncodingPatternEnum getEncryptionType() {
		return EncodingPatternEnum.SHA1;
	}

}
