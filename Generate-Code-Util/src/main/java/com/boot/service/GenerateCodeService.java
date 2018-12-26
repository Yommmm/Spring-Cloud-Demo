package com.boot.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.CGConditions;
import com.boot.entity.TableStructure;
import com.boot.utils.StringUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

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
	
	public void generateCode(CGConditions cgCondition) {
		// 数据模板目录
		String templatePath = "src/main/resources/ftls";
		
		// 生成文件的父目录
		String packParent = "target/module/";
		
		List<String> tableList = dbService.getTableList();
		
		for(String tableName : tableList) {
			System.out.println("开始生成表" + tableName + "的实体类...");
			List<TableStructure> tableInfo = dbService.getTableInfo(tableName);
			if(tableName.indexOf("lms_wms_") > -1) {
				tableName = StringUtil.removePrefix(tableName, "lms_wms_");
			} else {
				System.out.println("生成失败！表" + tableName + "已被过滤！\n");
				continue;
			}
			
			for(TableStructure tableStructure : tableInfo) {
				tableStructure.setType(this.dataType(tableStructure.getType()));
				tableStructure.setFieldName(StringUtil.underlineToCamel(tableStructure.getField()));
				
				String fieldName = tableStructure.getFieldName();
				tableStructure.setUcFieldName(StringUtil.firstCharToUpCase(fieldName));
			}
			
			String packName = StringUtil.underlineToCamel(tableName);
			String beanName = StringUtil.firstCharToUpCase(packName);
			
			// 生成实体类
			this.generateFile(templatePath, 
					"bean", 
					packParent + packName + "/" + "bean/", 
					beanName, 
					"com.zlst.module." + packName + ".bean", 
					tableName, 
					tableInfo,
					null);
			
			// 生成DAO
			this.generateFile(templatePath, 
					"repository", 
					packParent + packName + "/" + "repository/", 
					beanName + "Repository", 
					"com.zlst.module." + packName + ".repository", 
					tableName, 
					null,
					beanName);
			
			System.out.println("生成表" + tableName + "的实体类成功！\n");
		}
		
	}
	
	/**
	 * 生成Java文件，这里可以用工厂模式，或者观察者模式
	 * @param templatePath 模板路径
	 * @param templateName 模板名称
	 * @param filePath 目标文件夹
	 * @param fileName 目标文件名
	 * @param classPath 包名
	 * @param tableName 表名
	 * @param tableInfo 表结构信息
	 */
	private void generateFile(String templatePath, 
			String templateName, 
			String filePath, 
			String fileName, 
			String packName,
			String tableName,
			List<TableStructure> tableInfo,
			String beanName) {
		// step1 创建freeMarker配置实例
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
		Writer out = null;
		try {
			// step2 获取模版路径
			configuration.setDirectoryForTemplateLoading(new File(templatePath));
			
			// step3 创建数据模型
			Map<String, Object> dataModal = new HashMap<String, Object>();
			
			if("bean".equals(templateName)) {
				dataModal.put("classPath", packName);
				dataModal.put("tableName", tableName);
				dataModal.put("className", fileName);
				dataModal.put("fields", tableInfo);
			} else if("repository".equals(templateName)) {
				dataModal.put("classPath", packName);
				dataModal.put("packName", tableName);
				dataModal.put("beanName", beanName);
				dataModal.put("className", fileName);
			} else if("service".equals(templateName)) {
				
			} else if("controller".equals(templateName)) {
				
			}

			// step4 加载模版文件
			Template template = configuration.getTemplate(templateName + ".ftl");
			
			// step5 生成数据
			File docFile = this.generateFile(filePath, fileName + ".java");
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
			
			// step6 输出文件
			template.process(dataModal, out);
			System.out.println("表" + tableName + "生成" + fileName + ".java实体成功，路径为：" + docFile.getPath());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != out) {
					out.flush();
					out.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 * 创建文件方法
	 * @param path 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private File generateFile(String filePath, String fileName) throws IOException {
		// 指定路径如果没有则创建并添加
		File file = new File(filePath + fileName);
		
		// 获取父目录
		File fileParent = file.getParentFile();
		
		//判断是否存在
		if (!fileParent.exists()) {
			// 创建父目录文件
			fileParent.mkdirs();
		}
		file.createNewFile();
		
		return file;
	}
	
	private String dataType(String dataType) {
		if(dataType.indexOf("varchar") > -1) {
			return "String";
		} else if(dataType.indexOf("decimal") > -1) {
			return "BigDecimal";
		} else if(dataType.indexOf("datetime") > -1) {
			return "Date";
		} else {
			return "?";
		}
		
	}
	
}
