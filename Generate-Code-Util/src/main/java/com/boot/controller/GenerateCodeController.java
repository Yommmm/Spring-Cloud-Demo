package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.CGConditions;
import com.boot.service.GenerateCodeService;

@RestController
@RequestMapping("/cg/v1/generater")
public class GenerateCodeController {
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
	@PostMapping("/service")
	public String generateCode(CGConditions cgCondition) {
		generateCodeService.generateCode(cgCondition);
		return "success";
	}
	
}
