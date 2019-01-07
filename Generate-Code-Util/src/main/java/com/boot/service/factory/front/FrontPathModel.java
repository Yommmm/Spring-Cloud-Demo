package com.boot.service.factory.front;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;
import com.boot.service.factory.AbstractCodelModel;

public class FrontPathModel extends AbstractCodelModel {

	@Override
	public void generateCode(ModelParams modelParams) {
		modelParams.setFilePath(modelParams.getFilePathPre() + modelParams.getComponentPre() + "/js/");
		modelParams.setTemplateName("frontPath");
		modelParams.setFileName(modelParams.getFileName());
		
		Map<String, Object> dataParams = new HashMap<>();
		
		dataParams.put("packName", modelParams.getPackName());
		dataParams.put("componentPre", modelParams.getComponentPre());
		
		this.generateFile(modelParams, dataParams, true);
	}

}
