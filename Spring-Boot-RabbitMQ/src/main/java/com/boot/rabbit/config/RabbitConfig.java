package com.boot.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boot.rabbit.constant.RabbitConstant;

@Configuration
public class RabbitConfig {

	@Bean
	public Queue queue() {
		return new Queue(RabbitConstant.HELLO_QUEUE);
	}
}
