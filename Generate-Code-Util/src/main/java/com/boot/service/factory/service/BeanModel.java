package com.boot.service.factory.service;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;
import com.boot.service.factory.AbstractCodelModel;

public class BeanModel extends AbstractCodelModel {

	@Override
	public void generateCode(ModelParams modelParams) {
		modelParams.setFilePath(modelParams.getFilePathPre() + modelParams.getPackName() + "/bean/");
		modelParams.setTemplateName("bean");
		
		Map<String, Object> dataParams = new HashMap<>();
		
		dataParams.put("classPath", modelParams.getClassPathPre() + modelParams.getPackName() + ".bean");
		dataParams.put("tableName", modelParams.getTableName());
		dataParams.put("className", modelParams.getFileName());
		dataParams.put("fields", modelParams.getTableInfo());
		
		this.generateFile(modelParams, dataParams, false);
	}

}
