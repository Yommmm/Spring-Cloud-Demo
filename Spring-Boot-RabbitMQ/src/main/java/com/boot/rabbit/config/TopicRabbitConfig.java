package com.boot.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

	public static final String MESSAGE_A = "topic.messagea";
	
	public static final String MESSAGE_B = "topic.messageb";
	
	public static final String EXCHANGE = "exchange";
	
	/**
	 * 声明队列
	 * @return
	 */
	@Bean
	public Queue queueMessageA() {
		return new Queue(MESSAGE_A);
	}
	
	/**
	 * 声明队列
	 * @return
	 */
	@Bean
	public Queue queueMessageB() {
		return new Queue(MESSAGE_B);
	}
	
	/**
	 * 声明交换机
	 * @return
	 */
	@Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }
	
	@Bean
    public Binding bindingExchangeMessage(Queue queueMessageA, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageA).to(exchange).with(MESSAGE_B);
    }
	
	/**
	 * 声明RoutingKey绑定
	 * #代表0个到n个单词
	 * *代表一个单词
	 * 具体字符串代表绑定到指定RoutingKey，就像上面那个Bean声明
	 * @param queueMessageB
	 * @param exchange
	 * @return
	 */
	@Bean
    public Binding bindingExchangeMessages(Queue queueMessageB, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageB).to(exchange).with("topic.#");
    }
	
}
