package com.boot.service.factory;

import java.util.Map;

import com.boot.entity.ModelParams;

public interface CodeModel {

	Map<String, Object> generateCode(ModelParams modelParams);
	
}
