package com.boot.service.factory;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;

public class ControllerModel implements CodeModel {

	@Override
	public void generateCode(ModelParams modelParams) {
		Map<String, Object> dataParams = new HashMap<>();
		
		dataParams.put("classPath", modelParams.getClassPathPre() + modelParams.getPackName() + ".controller");
		dataParams.put("packName", modelParams.getPackName());
		dataParams.put("beanName", modelParams.getBeanName());
		dataParams.put("className", modelParams.getFileName());
		
	}

}
