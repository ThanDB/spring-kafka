package io.github.thandb.study.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.github.thandb.study.SpringKafkaApplication;
import io.github.thandb.study.kafka.config.KafkaConsumerConfig;
import io.github.thandb.study.kafka.config.KafkaProducerConfig;
import io.github.thandb.study.kafka.model.Message;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { SpringKafkaApplication.class, KafkaConsumerConfig.class, KafkaProducerConfig.class })
@EmbeddedKafka
public class MessageServiceTest {
	@Autowired
	KafkaTemplate<String, Message> kafkaTemplate;
	
	@Value("${kafka.topic.message}")
	String topic;
	
	@Test
	public void test() throws InterruptedException {
		var message = new Message();
		message.setSender("A");
		message.setReceiver("B");
		message.setMessage("Hello");
		kafkaTemplate.send(topic, message);
	}

}
