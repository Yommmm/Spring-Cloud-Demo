package ${classPath};

public class ${className} {
    
    <#list fields as fields>
		
		@Getter
		@Setter
		private ${fields.dataType} ${p.fieldName};
	
	</#list>
	
}