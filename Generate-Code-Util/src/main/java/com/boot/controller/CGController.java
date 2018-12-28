package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.CGConditions;
import com.boot.service.GenerateCodeService;
import com.boot.service.GenerateCodeService2;

@RestController
@RequestMapping("/cg/v1/generater")
public class CGController {
	
	@Autowired
	private GenerateCodeService generateCodeService;
	
	@Autowired
	private GenerateCodeService2 generateCodeService2;
	
	@PostMapping("/bean")
	public String generateBean(CGConditions cgCondition) {
//		generateCodeService.generateCode(cgCondition);
		generateCodeService2.generateCode(cgCondition);
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
