package com.boot.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.CGConditions;
import com.boot.entity.TableStructure;
import com.boot.utils.StringUtil;

/**
 * 代码生成类
 * @author 170186
 *
 */
@Service
public class CGService {

	private static final Logger logger = LoggerFactory.getLogger(CGService.class);
	
	@Autowired
	private DBService dbService;
	
	public void generateBean(CGConditions cgCondition) {
//		List<String> tableList = dbService.getTableList();
		
//		for(String tableName : tableList) {
			List<TableStructure> tableInfo = dbService.getTableInfo("lms_wms_goods_accept");
			
			for(TableStructure tableStructure : tableInfo) {
				tableStructure.setType(this.dataType(tableStructure.getType()));
				tableStructure.setFieldName(this.fieldName(tableStructure.getField()));
				
				System.out.println(tableStructure.toString());
			}
			
//		}
		
	}
	
	private String fieldName(String field) {
		field = StringUtil.underlineToCamel(field);
		return field;
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
