package com.codedecode.StrategyDesignPattern.encrpt;

import com.codedecode.StrategyDesignPattern.enums.EncodingPatternEnum;

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
