package com.boot.service.factory;

import java.util.HashMap;
import java.util.Map;

import com.boot.entity.ModelParams;

public class BeanModel implements CodeModel {

	@Override
	public Map<String, Object> generateCode(ModelParams modelParams) {
		Map<String, Object> dataParams = new HashMap<>();
		
		dataParams.put("classPath", modelParams.getClassPathPre() + modelParams.getPackName() + ".bean");
		dataParams.put("tableName", modelParams.getTableName());
		dataParams.put("className", modelParams.getFileName());
		dataParams.put("fields", modelParams.getTableInfo());
		
		return dataParams;
	}

}
