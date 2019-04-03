package com.boot.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/eeda/v1/demo")
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	private String command = "command";
	
	@GetMapping("/command")
	@ApiOperation(value = "心跳获取控制命令", notes="心跳获取控制命令API", produces = "application/json")
	public String getCommand() {
		logger.info("正在获取控制命令！");
		return this.command;
	}
	
	@PostMapping("/command")
	@ApiOperation(value = "修改控制命令", notes="修改控制命令API", produces = "application/json")
	public String setCommand(String command) {
		logger.info("正在修改控制命令为： {}", command);
		return this.command = command;
	}
	
	@PostMapping("/message")
	@ApiOperation(value = "设备发送消息到数据仓库接口", notes="设备发送消息到数据仓库API", produces = "application/json")
	public String sendMessage(Map<String, Object> params) {
		logger.info("正在传输设备数据： {}", JSONObject.toJSONString(params));
		return "sucess";
	}
	
}
