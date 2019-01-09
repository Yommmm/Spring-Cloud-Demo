package com.boot.config;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DelegatingDataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DynamicDataSourceOfDruid extends DruidDataSource {

	private static final long serialVersionUID = 1L;

	private static HashMap<String, String> dataBaseMap = new HashMap<>();
	public static ThreadLocal<DruidDataSource> connectionThreadLocal = new ThreadLocal<>();

	/**
	 * 数据源中配置注入不进来，因此自己写了一个读取property的类去读取连接配置
	 */
	@Autowired
	private DruidDataSourceProperty druidDataSourceProperty;

	static {
		dataBaseMap.put("1", "cxy");
		dataBaseMap.put("2", "cxy1");
	}

	@Override
	public DruidPooledConnection getConnection() {
		try {
			String db = DataSourceContextHolder.getDB();
			if (db == null) {
				db = "1";
			}
			Properties properties = this.getConnectProperties();
			Field[] declaredFields = druidDataSourceProperty.getClass().getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				properties.setProperty(field.getName(), (String) field.get(druidDataSourceProperty));
			}
			String urlFormat = properties.getProperty("url");
			String url = String.format(urlFormat, dataBaseMap.get(db));
			properties.setProperty("url", url);
			DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
			DruidPooledConnection connection = (DruidPooledConnection) dataSource.getConnection();
			connectionThreadLocal.set((DruidDataSource) dataSource);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeConnection() {
		DruidDataSource druidDataSource = connectionThreadLocal.get();
		if (druidDataSource != null) {
			try {
				druidDataSource.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
