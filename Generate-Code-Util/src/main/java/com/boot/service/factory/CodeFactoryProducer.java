package com.boot.service.factory;

import org.springframework.stereotype.Component;

@Component
public class CodeFactoryProducer {

	public CodeModel getFactory(String factoryType) {
		if(null == factoryType || "".equals(factoryType)) {
			return null;
		}
		
		if(factoryType.equalsIgnoreCase("bean")) {
			return new BeanModel();
		}
		
		if(factoryType.equalsIgnoreCase("repository")) {
			return new RepositoryModel();
		}
		
		if(factoryType.equalsIgnoreCase("service")) {
			return new ServiceModel();
		}
		
		if(factoryType.equalsIgnoreCase("controller")) {
			return new ControllerModel();
		}
		
		return null;
		
	}
	
}
