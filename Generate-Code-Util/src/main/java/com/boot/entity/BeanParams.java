package com.boot.entity;

import java.util.List;

public class BeanParams extends BaseParams {
	
	private List<TableStructure> tableInfo;

	public List<TableStructure> getTableInfo() {
		return tableInfo;
	}

	public void setTableInfo(List<TableStructure> tableInfo) {
		this.tableInfo = tableInfo;
	}
	
}
