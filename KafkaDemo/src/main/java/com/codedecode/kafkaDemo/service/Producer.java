package com.codedecode.kafkaDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	//very simple message
	public void sendMsgToTopic(String message) {
		kafkaTemplate.send("codeDecode_Topic", message);  //send(String topic, @Nullable String data)
		
	}

}
