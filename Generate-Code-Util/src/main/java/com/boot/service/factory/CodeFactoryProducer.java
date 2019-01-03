package com.boot.service.factory;

import org.springframework.stereotype.Component;

import com.boot.service.factory.front.FrontIndexModel;
import com.boot.service.factory.front.FrontPathModel;
import com.boot.service.factory.service.BeanModel;
import com.boot.service.factory.service.ControllerModel;
import com.boot.service.factory.service.RepositoryModel;
import com.boot.service.factory.service.ServiceModel;
import com.boot.service.factory.service.VOModel;

@Component
public class CodeFactoryProducer {

	public CodeModel getFactory(String factoryType) {
		if(null == factoryType || "".equals(factoryType)) {
			return null;
		}
		
		if(factoryType.equalsIgnoreCase("bean")) {
			return new BeanModel();
		}
		
		if(factoryType.equalsIgnoreCase("vo")) {
			return new VOModel();
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
		
		if(factoryType.equalsIgnoreCase("frontIndex")) {
			return new FrontIndexModel();
		}
		
		if(factoryType.equalsIgnoreCase("frontPath")) {
			return new FrontPathModel();
		}
		
		return null;
		
	}
	
}
