package com.boot.bean.common.entity;

public class Result {

	private String resultCode;
	
	private String resultMsg;
	
	private Object data;
	
	public Result(String resultCode, String resultMsg, Object data) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.data = data;
	}
	
	public Result(Object data) {
		this.resultCode = "200";
		this.resultMsg = "success";
		this.data = data;
	}
	
	public static Result ToResult(Object data) {
		return new Result(data);
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
