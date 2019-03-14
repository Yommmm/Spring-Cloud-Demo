package com.boot.rabbit.hello;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.rabbit.constant.RabbitConstant;
import com.boot.rabbit.vo.User;

@Component
public class HelloSender {

	private static final Logger logger = LoggerFactory.getLogger(HelloSender.class);
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send() {
		String hello = "hello" + (new Date()).getTime();
		Map<String, String> context = new HashMap<String, String>();
		context.put("hello", hello);
		logger.info("Sender1: " + context.get("hello"));
		rabbitTemplate.convertAndSend(RabbitConstant.HELLO_QUEUE, context);
	}
	
	public void send2() {
		String hello = "hello" + (new Date()).getTime();
		Map<String, String> context = new HashMap<String, String>();
		context.put("hello", hello);
		logger.info("Sender2: " + context);
		rabbitTemplate.convertAndSend(RabbitConstant.HELLO_QUEUE, context);
	}
	
	public void sendObject() {
		User user = new User();
		user.setName("AAA");
		user.setAge("BBB");
		user.setAddress("CCC");
		rabbitTemplate.convertAndSend(RabbitConstant.HELLO_QUEUE, user);
	}
	
}
