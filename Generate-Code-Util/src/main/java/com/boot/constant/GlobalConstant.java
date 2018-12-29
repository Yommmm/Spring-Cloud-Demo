package com.boot.constant;

public class GlobalConstant {

	public static enum CodeFactoryType {
		BEAN("bean"), VO("vo"), REPOSITORY("repository"), SERVICE("service"), CONTROLLER("controller");
		
		public String codeFactoryType;
		
		public String getCodeFactoryType() {
			return this.codeFactoryType;
		}

		CodeFactoryType(String codeFactoryType) {
	        this.codeFactoryType = codeFactoryType;
	    }
		
	}
	
}
