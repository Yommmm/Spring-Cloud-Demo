package com.boot.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.boot.entity.Mail;

/**
 * 邮件服务
 * @author 170186
 *
 */
@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSerder;
	
	public Mail sendMail(Mail mail) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom(mail.getSenderAddr());
		simpleMailMessage.setTo(mail.getReceiverAddr());
		simpleMailMessage.setSubject(mail.getSubject());
		simpleMailMessage.setText(mail.getContent());
		simpleMailMessage.setSentDate(new Date());
		
		mailSerder.send(simpleMailMessage);
		return mail;
	}

}
