package ${packageName}.${beanName};
/**
**/
public class ${beanNameClass} {
	/**
	**/
	<#list metaDataList as metaData>
		private ${metaData.variableType} ${metaData.fieldName};
	</#list>
	
	/**
	**/
	public ${beanNameClass}(){
		super();
	}
	
	/** 
	* setter  and  getter
	**/
	<#list metaDataList as metaData>
		public ${metaData.variableType} get${metaData.fuFieldName}(){
			return ${metaData.fieldName};
		}
		
		public void set${metaData.fuFieldName}(${metaData.variableType} ${metaData.fieldName}){
			this.${metaData.fieldName}=${metaData.fieldName};
		}
	</#list>
}