package com.boot.service.factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import com.boot.entity.ModelParams;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class AbstractCodelModel implements CodeModel {

	@Override
	public void generateCode(ModelParams modelParams) {
		
	}
	
	public void generateFile(ModelParams modelParams, Map<String, Object> dataParams, boolean isFront) {
		// 创建freeMarker配置实例
		Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
		Writer out = null;
		try {
			// 获取模版路径
			configuration.setDirectoryForTemplateLoading(new File(modelParams.getTemplatePath()));
			
			// 加载模版文件
			Template template = configuration.getTemplate(modelParams.getTemplateName() + ".ftl");
			
			// 生成数据
			File docFile = this.generateFile(modelParams.getFilePath(), modelParams.getFileName() + (isFront ? ".vue" : ".java"));
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
			
			// 输出文件
			template.process(dataParams, out);
			System.out.println("表 " + modelParams.getTableName() + " 生成 " + modelParams.getFileName() + ".java 文件成功，路径为：" + docFile.getPath());
			
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
	
}
