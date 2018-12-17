package com.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Mail;
import com.boot.service.MailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 邮件发送服务
 * @author 170186
 *
 */
@Api(value = "邮件API")
@RestController
@RequestMapping("/boot/v2/mail")
public class MailController {

	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private MailService mailService;
	
	@PostMapping
	@ApiOperation(value = "发送邮件", notes="发送邮件API", produces = "application/json")
	public Object sendMail(@RequestBody Mail mail) {
		logger.info(mail.toString());
		return mailService.sendMail(mail);
	}
	
	@GetMapping("/{a}/{b}")
	@ApiOperation(value = "发送邮件", notes="发送邮件API", produces = "application/json")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "a", value = "A", dataType = "String", paramType = "path", required = true),
		@ApiImplicitParam(name = "b", value = "B", dataType = "String", paramType = "path", required = true)
	})
	public Object showSwaggerWith2Params(@PathVariable("a") String a, @PathVariable("b") String b) {
		return a + b;
	}
	
	
	/**
	 * 
	 * paramType 有五个可选值 ： path, query, body, header, form
	 */
	@GetMapping("/mail")
	@ApiOperation(value = "发送邮件", notes="发送邮件API", produces = "application/json")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "发件人", value = "senderAddr", dataType = "String", paramType = "query", required = true),
//		@ApiImplicitParam(name = "收件人", value = "receiverAddr", dataType = "String", paramType = "query", required = true),
//		@ApiImplicitParam(name = "邮件标题", value = "subject", dataType = "String", paramType = "query", required = true),
//		@ApiImplicitParam(name = "邮件内容", value = "content", dataType = "String", paramType = "query", required = true)
//	})
	public Object showSwaggerWithObject(Mail mail) {
		return mail.toString();
	}
	
	
}
