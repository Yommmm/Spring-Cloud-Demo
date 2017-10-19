package com.boot.rabbit.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello_queue")
public class HelloReceiver {

	private static final Logger logger = LoggerFactory.getLogger(HelloSender.class);
	
	@RabbitHandler
	public void process(String hello) {
		logger.info("Recevier: " + hello);
	}
	
}
