package com.boot.service.factory;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;

public class VOModel extends AbstractCodelModel {

	@Override
	public void generateCode(ModelParams modelParams) {
		modelParams.setFilePath(modelParams.getFilePathPre() + modelParams.getPackName() + "/vo/");
		modelParams.setTemplateName("vo");
		modelParams.setFileName(modelParams.getFileName() + "VO");
		
		Map<String, Object> dataParams = new HashMap<>();
		
		dataParams.put("classPath", modelParams.getClassPathPre() + modelParams.getPackName() + ".vo");
		dataParams.put("className", modelParams.getFileName());
		dataParams.put("fields", modelParams.getTableInfo());
		
		this.generateFile(modelParams, dataParams);
	}

}
