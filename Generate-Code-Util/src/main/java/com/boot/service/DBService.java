package com.boot.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.boot.entity.TableStructure;

@Service
public class DBService {

	private static final Logger logger = LoggerFactory.getLogger(DBService.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 获取所有数据表
	 * @return
	 */
	public List<String> getTableList() {
		List<String> queryResult = jdbcTemplate.query("SHOW TABLES", new RowMapper<String>() {
            
            public String mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
            	String result = rs.getString("Tables_in_logistics_wms_dev");
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
		List<TableStructure> queryResult = jdbcTemplate.query("DESC " + tableName, new RowMapper<TableStructure>() {
            
            public TableStructure mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
            	TableStructure tableStructure = new TableStructure();
            	tableStructure.setField(rs.getString("Field"));
            	tableStructure.setType(rs.getString("Type"));
            	tableStructure.setNullable(rs.getString("Null"));
            	tableStructure.setKey(rs.getString("Key"));
            	tableStructure.setDefaultable(rs.getString("Default"));
            	tableStructure.setExtra(rs.getString("Extra"));
                return tableStructure;
            }
        });
		
		return queryResult;
	}
	
}
