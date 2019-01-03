package com.boot.service.factory.front;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;
import com.boot.service.factory.AbstractCodelModel;

public class FrontDetailModel extends AbstractCodelModel {

	@Override
	public void generateCode(ModelParams modelParams) {
		modelParams.setFilePath(modelParams.getFilePathPre() + modelParams.getComponentPre() + "/");
		modelParams.setTemplateName("frontIndex");
		modelParams.setFileName(modelParams.getFileName() + "Index");
		
		Map<String, Object> dataParams = new HashMap<>();
		
		dataParams.put("componentPre", modelParams.getComponentPre());
		dataParams.put("packName", modelParams.getPackName());
		dataParams.put("fields", modelParams.getTableInfo());
		
		this.generateFile(modelParams, dataParams, true);
	}

}
