package com.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boot/v2/retry")
public class RetryController {
	
	private int counter = 1;

	@GetMapping
	public String retry() {
		if(counter < 9) {
			counter++;
			System.out.println("第" + (counter - 1) + "次失败");
			throw new RuntimeException("第" + (counter - 1) + "次失败");
		}
		return "success";
	}
	
}
