package com.boot.rabbit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

	private static final Logger logger = LoggerFactory.getLogger(TopicSender.class);
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send1() {
	    String context = "hi, i am message 1";
	    logger.info("Sender1 : " + context);
	    rabbitTemplate.convertAndSend("exchange", "topic.message", context);
	}

	public void send2() {
	    String context = "hi, i am messages 2";
	    logger.info("Sender2 : " + context);
	    rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
	}
}
