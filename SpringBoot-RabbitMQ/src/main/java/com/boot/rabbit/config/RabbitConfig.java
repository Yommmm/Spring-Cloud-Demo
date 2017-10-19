package com.boot.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	public Queue queue() {
		return new Queue("hello");
	}
}
