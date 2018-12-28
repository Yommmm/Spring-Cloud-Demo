package com.boot.service.factory;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;

public class ServiceModel implements CodeModel {

	@Override
	public Map<String, Object> generateCode(ModelParams modelParams) {
		Map<String, Object> dataParams = new HashMap<>();
		
		dataParams.put("classPath", modelParams.getClassPathPre() + modelParams.getPackName() + ".service");
		dataParams.put("packName", modelParams.getPackName());
		dataParams.put("beanName", modelParams.getBeanName());
		dataParams.put("className", modelParams.getFileName());
		
		return dataParams;
	}

}
