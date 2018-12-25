package ${classPath};.

<#list imports as imports>
import 
</#list>

public class ${className} {
    
<#list fields as fields>
	@Getter
	@Setter
	private ${fields.type} ${fields.field};
</#list>
	
}