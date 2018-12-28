package com.boot.entity;

import java.util.List;

public class ModelParams {

	/**
	 * 模板路径
	 */
	private String templatePath;
	
	/**
	 * 模板名称
	 */
	private String templateName; 
	
	/**
	 * 生成文件的路径
	 */
	private String filePath;
	
	/**
	 * 文件名/类名
	 */
	private String fileName; 
	
	/**
	 * 类的包名
	 * 第一行
	 * package com.xxx.xxx.xxx
	 */
	private String classPath;
	
	/**
	 * 模块根包名
	 */
	private String packName; 
	
	/**
	 * 依赖的Bean名
	 */
	private String beanName;
	
	/**
	 * 表名
	 */
	private String tableName;

	/**
	 * 表数据结构
	 */
	private List<TableStructure> tableInfo;
	
	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public List<TableStructure> getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(List<TableStructure> tableInfo) {
		this.tableInfo = tableInfo;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
	
	
}
