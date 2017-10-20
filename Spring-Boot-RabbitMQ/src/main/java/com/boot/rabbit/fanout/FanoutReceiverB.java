package com.boot.rabbit.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.boot.rabbit.topic.TopicReceiver;

@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

private static final Logger logger = LoggerFactory.getLogger(TopicReceiver.class);
	
	@RabbitHandler
	public void process(String hello) {
		logger.info("RecevierB: " + hello);
	}
}
