package com.boot.rabbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rabbit.hello.HelloSender;
import com.boot.rabbit.topic.TopicSender;

@RestController
public class HelloController {

	@Autowired
	private HelloSender helloSender;
	
	@Autowired
	private TopicSender topicSender;
	
	@GetMapping("/sendhello")
	public String send() {
		helloSender.send();
		helloSender.send2();
		return "success";
	}
	
	@GetMapping("/sendtopic")
	public String sendTopic() {
		topicSender.send1();
		topicSender.send2();
		return "send topic success";
	}
	
}
