package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.CGConditions;
import com.boot.service.CGService;

@RestController
@RequestMapping("/cg/v1/generater")
public class CGController {
	
	@Autowired
	private CGService cgService;
	
	@PostMapping("/bean")
	public String generateBean(CGConditions cgCondition) {
		cgService.generateBean(cgCondition);
		return "success";
	}
	
	@PostMapping("/service")
	public String generateService(CGConditions cgCondition) {
		return "success";
	}
	
	@PostMapping("/controller")
	public String generateController(CGConditions cgCondition) {
		return "success";
	}

}
