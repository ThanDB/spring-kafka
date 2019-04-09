package io.github.thandb.study.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import io.github.thandb.study.kafka.model.Message;

@Service
public class MessageService {
	final Logger log = LoggerFactory.getLogger(getClass());
	
	@KafkaListener(topics = { "${kafka.topic.message}" })
	public void listen(@Payload(required = false) Message message) {
		log.info("Tada: {}" + message);
	}
}
