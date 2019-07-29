package com.boot.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boot/v2/hystrix")
public class HystrixController {

	@GetMapping
	public String hystrix() {
		try {
			System.out.println(new Date());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
}
