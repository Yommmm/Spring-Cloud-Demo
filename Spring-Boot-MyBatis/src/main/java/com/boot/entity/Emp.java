package com.boot.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Emp", description = "员工对象")
public class Emp {

	@ApiModelProperty(value = "编号")
	private String empId;
	
	@ApiModelProperty(value = "编码")
	private String empCode;
	
	@ApiModelProperty(value = "姓名")
	private String empName;
	
	@ApiModelProperty(value = "证件号")
	private String empIdCard;
	
	@ApiModelProperty(value = "地址")
	private String empAddr;
	
	@ApiModelProperty(value = "薪水")
	private Double salar;
	
	@ApiModelProperty(value = "活跃值")
	private String active;
	
	@ApiModelProperty(value = "状态")
	private String status;
	
	@ApiModelProperty(value = "创建时间")
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
