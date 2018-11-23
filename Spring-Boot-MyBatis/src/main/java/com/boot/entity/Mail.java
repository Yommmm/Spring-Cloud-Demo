package com.boot.entity;

public class Mail {

	private String senderAddr;
	
	private String receiverAddr;
	
	private String subject;
	
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
