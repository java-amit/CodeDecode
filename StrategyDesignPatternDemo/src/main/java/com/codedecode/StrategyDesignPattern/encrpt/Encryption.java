package com.codedecode.StrategyDesignPattern.encrpt;

import com.codedecode.StrategyDesignPattern.enums.EncodingPatternEnum;

public interface Encryption {
	
	public void encrypt(String toBeEncrypted);
	
	public EncodingPatternEnum getEncryptionType();

}
