package com.boot.rabbit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

	private static final Logger logger = LoggerFactory.getLogger(TopicReceiver.class);
	
	@RabbitHandler
	public void process(String hello) {
		logger.info("Recevier1: " + hello);
	}
	
}
