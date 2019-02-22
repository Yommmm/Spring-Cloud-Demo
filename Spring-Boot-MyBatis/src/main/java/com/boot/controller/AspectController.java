package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.common.entity.Result;
import com.boot.service.AspectService;

@RestController
@RequestMapping("/boot/v2/aspect")
public class AspectController {
	
	@Autowired
	private AspectService aspectService;
	
	@GetMapping("/{actor}")
	public Object aspect(@PathVariable String actor) {
		return Result.ToResult(aspectService.aspect(actor));
	}

}
