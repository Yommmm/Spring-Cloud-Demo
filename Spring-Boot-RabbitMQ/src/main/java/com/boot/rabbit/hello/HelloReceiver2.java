package com.boot.rabbit.hello;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello_queue")
public class HelloReceiver2 {

	private static final Logger logger = LoggerFactory.getLogger(HelloReceiver2.class);
	
	@RabbitHandler
	public void process(Map<String, String> hello) {
		logger.info("Recevier2: " + hello);
	}
	
}
