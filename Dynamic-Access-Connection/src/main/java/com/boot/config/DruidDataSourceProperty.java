package com.boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidDataSourceProperty {

	private String url;
	private String username;
	private String password;
	private String type;
	private String driverClassName;
	private String initialSize;
	private String minIdle;
	private String maxActive;
	private String timeBetweenEvictionRunsMillis;
	private String minEvictableIdleTimeMillis;
	private String validationQuery;
	private String testWhileIdle;
	private String testOnBorrow;
	private String testOnReturn;
	private String testConnectionOnCheckout;
	private String poolPreparedStatements;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(String initialSize) {
		this.initialSize = initialSize;
	}

	public String getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(String minIdle) {
		this.minIdle = minIdle;
	}

	public String getMaxActive() {
		return maxActive;
	}

	public void setMaxActive(String maxActive) {
		this.maxActive = maxActive;
	}

	public String getTimeBetweenEvictionRunsMillis() {
		return timeBetweenEvictionRunsMillis;
	}

	public void setTimeBetweenEvictionRunsMillis(String timeBetweenEvictionRunsMillis) {
		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	public String getMinEvictableIdleTimeMillis() {
		return minEvictableIdleTimeMillis;
	}

	public void setMinEvictableIdleTimeMillis(String minEvictableIdleTimeMillis) {
		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public String getTestWhileIdle() {
		return testWhileIdle;
	}

	public void setTestWhileIdle(String testWhileIdle) {
		this.testWhileIdle = testWhileIdle;
	}

	public String getTestOnBorrow() {
		return testOnBorrow;
	}

	public void setTestOnBorrow(String testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}

	public String getTestOnReturn() {
		return testOnReturn;
	}

	public void setTestOnReturn(String testOnReturn) {
		this.testOnReturn = testOnReturn;
	}

	public String getTestConnectionOnCheckout() {
		return testConnectionOnCheckout;
	}

	public void setTestConnectionOnCheckout(String testConnectionOnCheckout) {
		this.testConnectionOnCheckout = testConnectionOnCheckout;
	}

	public String getPoolPreparedStatements() {
		return poolPreparedStatements;
	}

	public void setPoolPreparedStatements(String poolPreparedStatements) {
		this.poolPreparedStatements = poolPreparedStatements;
	}

}
