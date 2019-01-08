package com.boot.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.boot.entity.TableStructure;
import com.boot.utils.StringUtil;

@Service
public class DBService {

	private static final Logger logger = LoggerFactory.getLogger(DBService.class);
	
	private static final Map<String, String> dataTypeMap = new HashMap<String, String>();
	
	static {
		dataTypeMap.put("varchar", "String");
		dataTypeMap.put("decimal", "BigDecimal");
		dataTypeMap.put("date", "Date");
		dataTypeMap.put("time", "Date");
		dataTypeMap.put("year", "Date");
		dataTypeMap.put("datetime", "Date");
		dataTypeMap.put("tinyint", "Integer");
		dataTypeMap.put("smallint", "Integer");
		dataTypeMap.put("mediumint", "Integer");
		dataTypeMap.put("int", "Integer");
		dataTypeMap.put("bigint", "Integer");
		dataTypeMap.put("integer", "Integer");
		dataTypeMap.put("double", "Double");
		dataTypeMap.put("float", "Float");
	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 获取所有数据表
	 * @return
	 */
	public List<String> getTableList() {
		StringBuffer sql = new StringBuffer("SELECT t.TABLE_NAME, t.TABLE_COMMENT ");
		sql.append("FROM INFORMATION_SCHEMA.tables t ");
		sql.append("WHERE t.TABLE_SCHEMA = " + "'sc_base_dev'");
		
		List<String> queryResult = jdbcTemplate.query(sql.toString(), new RowMapper<String>() {
            
            public String mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
            	String result = rs.getString("TABLE_NAME");
                return result;
            }
        });
		return queryResult;
	}
	
	/**
	 * 根据表名获取表结构信息
	 * @param tableName
	 * @return
	 */
	public List<TableStructure> getTableInfo(String tableName) {
		StringBuilder sql = new StringBuilder("SELECT t.COLUMN_NAME, t.DATA_TYPE, ");
		sql.append("t.CHARACTER_MAXIMUM_LENGTH AS MAX_LENGTH, t.IS_NULLABLE, t.COLUMN_KEY, t.COLUMN_COMMENT ");
		sql.append("FROM INFORMATION_SCHEMA.COLUMNS t ");
		sql.append("WHERE TABLE_NAME = '" + tableName + "' ");
		sql.append("AND t.TABLE_SCHEMA = 'sc_base_dev' ");
		sql.append("ORDER BY t.ORDINAL_POSITION ASC");
		
		List<TableStructure> queryResult = jdbcTemplate.query(sql.toString(), new RowMapper<TableStructure>() {
            
            public TableStructure mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
            	TableStructure tableStructure = new TableStructure();
            	tableStructure.setField(rs.getString("COLUMN_NAME"));
            	tableStructure.setType(rs.getString("DATA_TYPE"));
            	tableStructure.setNullable(rs.getString("IS_NULLABLE"));
            	tableStructure.setKey(rs.getString("COLUMN_KEY"));
            	tableStructure.setMaxLength(rs.getDouble("MAX_LENGTH"));
            	tableStructure.setColumnComment(rs.getString("COLUMN_COMMENT"));
                return tableStructure;
            }
        });
		
		for(TableStructure tableStructure : queryResult) {
			tableStructure.setType(this.dataType(tableStructure.getType()));
			tableStructure.setFieldName(StringUtil.underlineToCamel(tableStructure.getField()));
			
			String fieldName = tableStructure.getFieldName();
			tableStructure.setUcFieldName(StringUtil.firstCharToUpCase(fieldName));
			tableStructure.setFrontColumnName(StringUtil.removeAfterChars(tableStructure.getColumnComment(), "\n"));
		}
		
		return queryResult;
	}
	
	private String dataType(String dataType) {
		if(null != dataTypeMap.get(dataType)) {
			return dataTypeMap.get(dataType);
		} else {
			return "?";
		}
	}
	
}
