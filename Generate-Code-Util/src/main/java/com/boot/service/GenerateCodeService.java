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
		String templatePath = "src/main/resources/ftls/service";
		String frontTemplatePath = "src/main/resources/ftls/front";
		
		// 生成文件的父目录
		String filePathPre = "target/module/";
		String frontFilePathPre = "target/page/";
		
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
			
			/**
			 * 后端代码工厂
			 */
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
			
			// 前端代码生成路径
			modelParams.setFilePathPre(frontFilePathPre);
			
			/**
			 * 前端代码工厂
			 */
			ModelParams frontModelParams = new ModelParams();
			frontModelParams.setTemplatePath(frontTemplatePath);
			frontModelParams.setTemplateName(null);
			frontModelParams.setFilePathPre(frontFilePathPre);
			frontModelParams.setFilePath(null);
			frontModelParams.setFileName(packName);
			frontModelParams.setClassPathPre(classPathPre);
			frontModelParams.setPackName(packName);
			frontModelParams.setBeanName(beanName);
			frontModelParams.setTableName(tableName);
			frontModelParams.setTableInfo(tableInfo);
			frontModelParams.setComponentPre(StringUtil.camelToCenterline(packName));
			
			CodeModel frontIndexFactory = codeFactoryProducer.getFactory("frontIndex");
			frontIndexFactory.generateCode(frontModelParams);
			
			CodeModel frontPathFactory = codeFactoryProducer.getFactory("frontPath");
			frontPathFactory.generateCode(frontModelParams);
			
			System.out.println("生成表 " + tableName + " 的后端源码文件成功！\n");
		}
		
		logger.info("finish...");
	}
	
}
