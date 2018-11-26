package com.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.common.entity.Result;
import com.boot.feign.JpaRemote;

@RestController
@RequestMapping("/boot/v2/feign")
public class FeignController {

	private static final Logger logger = LoggerFactory.getLogger(FeignController.class);
	
	@Autowired
	private JpaRemote jpaRemote;
	
	@GetMapping
	public Result test() {
		logger.info("come on!");
		return Result.ToResult(jpaRemote.getPath("12306"));
	}
	
}
