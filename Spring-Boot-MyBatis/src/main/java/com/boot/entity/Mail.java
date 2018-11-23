package com.boot.entity;

public class Mail {

	/**
	 * 发件人
	 */
	private String senderAddr = "1529133840@qq.com";
	
	/**
	 * 收件人
	 */
	private String receiverAddr;
	
	/**
	 * 标题
	 */
	private String subject;
	
	/**
	 * 内容
	 */
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
