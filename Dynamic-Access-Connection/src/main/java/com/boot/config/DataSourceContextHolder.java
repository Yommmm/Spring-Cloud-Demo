package com.boot.config;

public class DataSourceContextHolder {

	private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	// 设置数据源名
	public static void setDB(String db) {
		contextHolder.set(db);
	}

	// 获取数据源名
	public static String getDB() {
		return contextHolder.get();
	}

	// 清空数据源
	public static void clearDB() {
		contextHolder.remove();
	}

}
