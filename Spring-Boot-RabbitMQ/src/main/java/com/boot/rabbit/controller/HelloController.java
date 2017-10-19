package com.boot.rabbit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rabbit.hello.HelloSender;

@RestController
public class HelloController {

	@Autowired
	private HelloSender helloSender;
	
	@GetMapping("/send")
	public String send() {
		helloSender.send();
		return "success";
	}
	
}
