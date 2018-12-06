package com.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.common.entity.Result;

@RestController
@RequestMapping("/boot/v2/config")
public class ConfigController {

	@Value("${hahahahah}")
	private String hahahahah;
	
	@GetMapping("/hahahahah")
	public Object getConfig() {
		return Result.ToResult(hahahahah);
	}
	
}
