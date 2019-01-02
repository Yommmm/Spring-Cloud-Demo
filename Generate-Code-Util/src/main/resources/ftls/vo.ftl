package ${classPath};

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import com.zlst.common.base.BaseQuery;

public class ${className} extends BaseQuery {
    
<#list fields as fields>
    <#if fields.fieldName != "active" && fields.fieldName != "createdBy" && fields.fieldName != "createTime" 
    	&& fields.fieldName != "modifiedBy" && fields.fieldName != "modifyTime">
    /**
	 * ${fields.columnComment}
	 */
	private ${fields.type} ${fields.fieldName};
	
	</#if>
</#list>
<#list fields as fields>
	<#if fields.fieldName != "active" && fields.fieldName != "createdBy" && fields.fieldName != "createTime" 
    	&& fields.fieldName != "modifiedBy" && fields.fieldName != "modifyTime">
	public void set${fields.ucFieldName}(${fields.type} ${fields.fieldName}) {
		this.${fields.fieldName} = ${fields.fieldName};
	}
	
	public ${fields.type} get${fields.ucFieldName}() {
		return this.${fields.fieldName};
	}
	
	</#if>
</#list>
	
}