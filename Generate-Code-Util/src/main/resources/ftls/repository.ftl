package ${classPath};

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.zlst.common.base.bean.BaseBean;

@Entity
@Table(name="${tableName}")
public class ${className} extends BaseBean {
    
<#list fields as fields>
    <#if fields.key == "PRI">
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	</#if>
    @Column(name = "${fields.field}")
	private ${fields.type} ${fields.fieldName};
	
</#list>
<#list fields as fields>
	public void set${fields.ucFieldName}(${fields.type} ${fields.fieldName}) {
		this.${fields.fieldName} = ${fields.fieldName};
	}
	
	public ${fields.type} get${fields.ucFieldName}() {
		return this.${fields.fieldName};
	}
	
</#list>
	
}