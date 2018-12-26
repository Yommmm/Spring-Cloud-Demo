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
public class GenerateBeanCodeService {

	private static final Logger logger = LoggerFactory.getLogger(GenerateBeanCodeService.class);
	
	@Autowired
	private DBService dbService;
	
	public void generateBean(CGConditions cgCondition) {
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
			
			this.generateFile(templatePath, 
					"bean", packParent + packName + "/" + "bean/", 
					beanName, 
					"com.zlst.module." + packName + ".bean", 
					tableName, 
					tableInfo);
			
			System.out.println("生成表" + tableName + "的实体类成功！\n");
		}
		
	}
	
	private void generateFile(String templatePath, String templateName, String filePath, 
			String fileName, 
			String classPath,
			String tableName,
			List<TableStructure> tableInfo) {
		// step1 创建freeMarker配置实例
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
		Writer out = null;
		try {
			// step2 获取模版路径
			configuration.setDirectoryForTemplateLoading(new File(templatePath));
			
			// step3 创建数据模型
			Map<String, Object> dataModal = new HashMap<String, Object>();
			
			dataModal.put("classPath", classPath);
			dataModal.put("tableName", tableName);
			dataModal.put("className", fileName);
			dataModal.put("fields", tableInfo);

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