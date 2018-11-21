package com.boot.entity;

import java.util.Date;

public class Emp {

	private String empId;
	
	private String empCode;
	
	private String empName;
	
	private String empIdCard;
	
	private String empAddr;
	
	private Double salar;
	
	private String active;
	
	private String status;
	
	private Date createTime;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpIdCard() {
		return empIdCard;
	}

	public void setEmpIdCard(String empIdCard) {
		this.empIdCard = empIdCard;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	public Double getSalar() {
		return salar;
	}

	public void setSalar(Double salar) {
		this.salar = salar;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
