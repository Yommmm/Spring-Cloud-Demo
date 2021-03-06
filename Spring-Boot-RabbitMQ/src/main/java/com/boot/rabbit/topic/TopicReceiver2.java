package com.boot.rabbit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.boot.rabbit.config.TopicRabbitConfig;

@Component
@RabbitListener(queues = TopicRabbitConfig.MESSAGE_B)
public class TopicReceiver2 {

	private static final Logger logger = LoggerFactory.getLogger(TopicReceiver2.class);
	
	@RabbitHandler
	public void process(String hello) {
		logger.info("Recevier2: " + hello);
	}
	
}
