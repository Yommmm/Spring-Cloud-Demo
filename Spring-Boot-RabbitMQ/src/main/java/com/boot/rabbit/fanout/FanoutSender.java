package com.boot.rabbit.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {

	private static final Logger logger = LoggerFactory.getLogger(FanoutReceiverC.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hi, fanout msg ";
		logger.info("Sender : " + context);
		rabbitTemplate.convertAndSend("fanoutExchange", "", context);
	}
}
