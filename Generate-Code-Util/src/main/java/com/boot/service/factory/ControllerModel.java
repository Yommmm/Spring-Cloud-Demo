package com.boot.service.factory;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;

public class ControllerModel extends AbstractCodelModel {

	@Override
	public void generateCode(ModelParams modelParams) {
		modelParams.setFilePath(modelParams.getFilePathPre() + modelParams.getPackName() + "/controller/");
		modelParams.setTemplateName("controller");
		modelParams.setFileName(modelParams.getBeanName() + "Controller");
		
		Map<String, Object> dataParams = new HashMap<>();
		
		dataParams.put("classPath", modelParams.getClassPathPre() + modelParams.getPackName() + ".controller");
		dataParams.put("packName", modelParams.getPackName());
		dataParams.put("beanName", modelParams.getBeanName());
		dataParams.put("className", modelParams.getFileName());
		
		this.generateFile(modelParams, dataParams);
	}

}
