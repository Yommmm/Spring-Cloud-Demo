package com.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cg/v1/generater")
public class CGController {
	
	
	@GetMapping("/bean")
	public String generateBean() {
		return "success";
	}
	
	@GetMapping("/service")
	public String generateService() {
		return "success";
	}
	
	@GetMapping("/controller")
	public String generateController() {
		return "success";
	}

}
