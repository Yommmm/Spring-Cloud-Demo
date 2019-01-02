package com.boot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.CGConditions;
import com.boot.entity.ModelParams;
import com.boot.entity.TableStructure;
import com.boot.service.factory.CodeFactoryProducer;
import com.boot.service.factory.CodeModel;
import com.boot.utils.StringUtil;

/**
 * 代码生成类
 * @author 170186
 *
 */
@Service
public class GenerateCodeService {

	private static final Logger logger = LoggerFactory.getLogger(GenerateCodeService.class);
	
	@Autowired
	private DBService dbService;
	
	@Autowired
	private CodeFactoryProducer codeFactoryProducer;
	
	public void generateCode(CGConditions cgCondition) {
		logger.info("start...");
		
		// 数据模板目录
		String templatePath = "src/main/resources/ftls";
		
		// 生成文件的父目录
		String filePathPre = "target/module/";
		
		String classPathPre = "com.zlst.module.";
		
		List<String> tableList = dbService.getTableList();
		
		for(String tableName : tableList) {
			System.out.println("开始生成表 " + tableName + " 的Java源码文件...");
			String tableNameDeal = null;
			if(tableName.indexOf("lms_wms_") > -1) {
				tableNameDeal = StringUtil.removePrefix(tableName, "lms_wms_");
			} else {
				System.out.println("生成失败！表" + tableName + "已被过滤！\n");
				continue;
			}
			List<TableStructure> tableInfo = dbService.getTableInfo(tableName);
			
			String packName = StringUtil.underlineToCamel(tableNameDeal);
			String beanName = StringUtil.firstCharToUpCase(packName);
			
			ModelParams modelParams = new ModelParams();
			modelParams.setTemplatePath(templatePath);
			modelParams.setTemplateName(null);
			modelParams.setFilePathPre(filePathPre);
			modelParams.setFilePath(null);
			modelParams.setFileName(beanName);
			modelParams.setClassPathPre(classPathPre);
			modelParams.setPackName(packName);
			modelParams.setBeanName(beanName);
			modelParams.setTableName(tableName);
			modelParams.setTableInfo(tableInfo);
			
			CodeModel beanFactory = codeFactoryProducer.getFactory("bean");
			beanFactory.generateCode(modelParams);
			
			CodeModel voFactory = codeFactoryProducer.getFactory("vo");
			voFactory.generateCode(modelParams);
			
			CodeModel repositoryFactory = codeFactoryProducer.getFactory("repository");
			repositoryFactory.generateCode(modelParams);
			
			CodeModel serviceFactory = codeFactoryProducer.getFactory("service");
			serviceFactory.generateCode(modelParams);
			
			CodeModel controllerFactory = codeFactoryProducer.getFactory("controller");
			controllerFactory.generateCode(modelParams);
			
			
			System.out.println("生成表 " + tableName + " 的Java源码文件成功！\n");
		}
		
		logger.info("finish...");
	}
	
}
