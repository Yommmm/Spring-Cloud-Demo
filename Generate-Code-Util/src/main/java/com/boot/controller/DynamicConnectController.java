package com.boot.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.pool.DruidDataSourceFactory;

@RestController
@RequestMapping("/dynamic/")
public class DynamicConnectController {
	
	private JdbcTemplate jdbcTemplate = null;
	
	/**
	 * 使用阿里Druid方式动态连接关系型数据库获取数据
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/druidPool")
	public Object druidPool() throws Exception {
		jdbcTemplate = new JdbcTemplate(this.druidDataSource());
		
		StringBuffer sql = new StringBuffer("SELECT t.TABLE_NAME, t.TABLE_COMMENT ");
		sql.append("FROM INFORMATION_SCHEMA.tables t ");
		sql.append("WHERE t.TABLE_SCHEMA = " + "'microservice'");
		
		List<String> queryResult = jdbcTemplate.query(sql.toString(), new RowMapper<String>() {
            
            public String mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
            	String result = rs.getString("TABLE_NAME");
                return result;
            }
        });
		return queryResult;
	}
	
	private DataSource druidDataSource() throws Exception {
		Map<String, String> property = new HashMap<String, String>();
		property.put("url", "jdbc:mysql://localhost:3306");
		property.put("username", "root");
		property.put("password", "root");
		
		DataSource dataSource = DruidDataSourceFactory.createDataSource(property);
		
		return dataSource;
	}
	
	/**
	 * 使用JDBC方式动态连接关系型数据库获取数据
	 * @return
	 */
	@GetMapping("/jdbcTemplate")
	public Object jdbcTemplate() {
		jdbcTemplate = new JdbcTemplate(this.dataSource());
		
		StringBuffer sql = new StringBuffer("SELECT t.TABLE_NAME, t.TABLE_COMMENT ");
		sql.append("FROM INFORMATION_SCHEMA.tables t ");
		sql.append("WHERE t.TABLE_SCHEMA = " + "'microservice'");
		
		List<String> queryResult = jdbcTemplate.query(sql.toString(), new RowMapper<String>() {
            
            public String mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
            	String result = rs.getString("TABLE_NAME");
                return result;
            }
        });
		return queryResult;
	}
	
	private DataSource dataSource() {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("root");
		DataSource build = dataSourceBuilder.build();
		return build;
	}

}
