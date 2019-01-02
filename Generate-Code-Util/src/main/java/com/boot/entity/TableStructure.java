package com.boot.entity;

/**
 * 表结构承载实体
 * @author 170186
 *
 */
public class TableStructure {
	
	/**
	 * 列名
	 */
	private String field;
	
	/**
	 * 字段名
	 */
	private String fieldName;
	
	/**
	 * 首字母大写的字段名
	 */
	private String ucFieldName;
	
	/**
	 * 数据类型
	 */
	private String type;
	
	/**
	 * 数据长度
	 */
	private Double maxLength;
	
	/**
	 * 能否为空
	 */
	private String nullable;
	
	/**
	 * 约束
	 */
	private String key;
	
	/**
	 * 注释及描述
	 */
	private String columnComment;
	
	/**
	 * 前端列名
	 */
	private String frontColumnName;
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getUcFieldName() {
		return ucFieldName;
	}

	public void setUcFieldName(String ucFieldName) {
		this.ucFieldName = ucFieldName;
	}

	public Double getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Double maxLength) {
		this.maxLength = maxLength;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}

	public String getFrontColumnName() {
		return frontColumnName;
	}

	public void setFrontColumnName(String frontColumnName) {
		this.frontColumnName = frontColumnName;
	}
	
	@Override
	public String toString() {
		return "TableStructure [field=" + field + ", fieldName=" + fieldName + ", ucFieldName=" + ucFieldName
				+ ", type=" + type + ", maxLength=" + maxLength + ", nullable=" + nullable + ", key=" + key
				+ ", columnComment=" + columnComment + ", frontColumnName=" + frontColumnName + "]";
	}
	
}
