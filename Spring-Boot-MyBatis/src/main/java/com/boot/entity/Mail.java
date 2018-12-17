package com.boot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Mail", description = "邮件内容对象")
public class Mail {

	/**
	 * 发件人
	 */
	@ApiModelProperty(value = "发件人")
	private String senderAddr = "1529133840@qq.com";
	
	/**
	 * 收件人
	 */
	@ApiModelProperty(value = "收件人", required = true)
	private String receiverAddr;
	
	/**
	 * 标题
	 */
	@ApiModelProperty(value = "邮件标题", required = true)
	private String subject;
	
	/**
	 * 内容
	 */
	@ApiModelProperty(value = "邮件内容", required = true)
	private String content;

	public String getSenderAddr() {
		return senderAddr;
	}

	public void setSenderAddr(String senderAddr) {
		this.senderAddr = senderAddr;
	}

	public String getReceiverAddr() {
		return receiverAddr;
	}

	public void setReceiverAddr(String receiverAddr) {
		this.receiverAddr = receiverAddr;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Mail [senderAddr=" + senderAddr + ", receiverAddr=" + receiverAddr + ", subject=" + subject
				+ ", content=" + content + "]";
	}
	
}
