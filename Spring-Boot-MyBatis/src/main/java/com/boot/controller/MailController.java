package com.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Mail;
import com.boot.service.MailService;

import io.swagger.annotations.ApiOperation;

/**
 * 邮件发送服务
 * @author 170186
 *
 */
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
	
}
