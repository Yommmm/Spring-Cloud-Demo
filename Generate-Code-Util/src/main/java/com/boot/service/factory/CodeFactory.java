package com.boot.service.factory;

import org.springframework.stereotype.Component;

import com.boot.entity.ModelParams;

@Component
public class CodeFactory {

	public CodeModel getParams(String modelType, ModelParams modelParams) {
		if(null == modelType || "".equals(modelType)) {
			return null;
		}
		
		if(modelType.equalsIgnoreCase("bean")) {
			return new BeanModel();
		}
		
		if(modelType.equalsIgnoreCase("repository")) {
			return new RepositoryModel();
		}
		
		if(modelType.equalsIgnoreCase("service")) {
			return new ServiceModel();
		}
		
		if(modelType.equalsIgnoreCase("constroller")) {
			return new ControllerModel();
		}
		
		return null;
		
	}
	
}
