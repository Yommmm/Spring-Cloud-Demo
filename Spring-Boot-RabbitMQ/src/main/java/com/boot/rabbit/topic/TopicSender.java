package com.boot.rabbit.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boot.rabbit.config.TopicRabbitConfig;

@Component
public class TopicSender {

	private static final Logger logger = LoggerFactory.getLogger(TopicSender.class);
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send1() {
	    String context = "hi, i am message 1";
	    logger.info("Sender1 : " + context);
	    rabbitTemplate.convertAndSend(TopicRabbitConfig.EXCHANGE, TopicRabbitConfig.MESSAGE_A, context);
	}

	public void send2() {
	    String context = "hi, i am message 2";
	    logger.info("Sender2 : " + context);
	    rabbitTemplate.convertAndSend(TopicRabbitConfig.EXCHANGE, TopicRabbitConfig.MESSAGE_B, context);
	}
}
