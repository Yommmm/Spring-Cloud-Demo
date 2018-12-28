package com.boot.service.factory;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;

public class RepositoryModel implements CodeModel {

	@Override
	public Map<String, Object> generateCode(String modelType, ModelParams modelParams) {
		Map<String, Object> dataParams = new HashMap<>();
		dataParams.put("classPath", modelParams.getClassPath());
		dataParams.put("packName", modelParams.getPackName());
		dataParams.put("beanName", modelParams.getBeanName());
		dataParams.put("className", modelParams.getFileName());
		
		return dataParams;
	}

}
