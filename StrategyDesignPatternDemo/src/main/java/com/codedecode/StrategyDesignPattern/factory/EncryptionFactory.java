package com.codedecode.StrategyDesignPattern.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codedecode.StrategyDesignPattern.encrpt.Encryption;
import com.codedecode.StrategyDesignPattern.enums.EncodingPatternEnum;

@Component
public class EncryptionFactory {

	Map<EncodingPatternEnum, Encryption> map;  //i will give you enum :key, you return me type of encryption: value.
	
	@Autowired
	public EncryptionFactory(Set<Encryption> encryptionTypeSet) {
		createStrategy(encryptionTypeSet);
	}

	private void createStrategy(Set<Encryption> encryptionTypeSet) {
		map = new HashMap<EncodingPatternEnum, Encryption>();
		encryptionTypeSet.stream()
				.forEach(encryptionTypes -> map.put(encryptionTypes.getEncryptionType(), encryptionTypes));
	}
	
	
	public Encryption findEncryptionType(EncodingPatternEnum encodingPatternEnum) {
		return map.get(encodingPatternEnum);
	}
}
