package com.boot.entity;

public class RepositoryParams extends BaseParams {

	private String packName; 
	
	private String beanName;

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
}
