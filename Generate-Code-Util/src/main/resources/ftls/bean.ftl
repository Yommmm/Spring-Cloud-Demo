package ${classPath};.

import java.util.Date;
import java.util.List;

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
@Table(name="LMS_WMS_GOODS_ARRIVE")
public class ${className} {
    
<#list fields as fields>
	@Getter
	@Setter
	@Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ARRIVE_NOTE_ID", length = 32)
	private ${fields.type} ${fields.field};
</#list>
	
}