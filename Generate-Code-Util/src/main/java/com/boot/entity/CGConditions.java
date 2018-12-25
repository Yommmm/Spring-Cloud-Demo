package com.boot.entity;

public class CGConditions {

	/**
	 * package prefix
	 */
	private String packagePath;
	
	/**
	 * 表前缀过滤
	 */
	private String tableNamePrefix;

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getTableNamePrefix() {
		return tableNamePrefix;
	}

	public void setTableNamePrefix(String tableNamePrefix) {
		this.tableNamePrefix = tableNamePrefix;
	}
	
}
