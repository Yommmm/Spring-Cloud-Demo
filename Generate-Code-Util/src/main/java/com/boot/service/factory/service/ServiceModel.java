package com.boot.service.factory.service;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;
import com.boot.service.factory.AbstractCodelModel;

public class ServiceModel extends AbstractCodelModel {

	@Override
	public void generateCode(ModelParams modelParams) {
		modelParams.setFilePath(modelParams.getFilePathPre() + modelParams.getPackName() + "/service/");
		modelParams.setTemplateName("service");
		modelParams.setFileName(modelParams.getBeanName() + "Service");
		
		Map<String, Object> dataParams = new HashMap<>();
		
		dataParams.put("classPath", modelParams.getClassPathPre() + modelParams.getPackName() + ".service");
		dataParams.put("packName", modelParams.getPackName());
		dataParams.put("beanName", modelParams.getBeanName());
		dataParams.put("className", modelParams.getFileName());
		dataParams.put("tableName", modelParams.getTableName());
		
		this.generateFile(modelParams, dataParams, false);
	}

}
