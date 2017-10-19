package com.boot.rabbit.hello;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.rabbit.constant.RabbitConstant;

public class HelloSender {

	private static final Logger logger = LoggerFactory.getLogger(HelloSender.class);
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send() {
		String context = "hello" + (new Date()).getTime();
		logger.info("Sender: " + context);
		rabbitTemplate.convertAndSend(RabbitConstant.HELLO_QUEUE, context);
	}
	
}
