package ${packageName};

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;


/**
**/
public class ${beanNameClass}Bean implements Serializable{
	/**
	**/
	<#list metaDataList as metaData>
		private ${metaData.variableType} ${metaData.fieldName};
	</#list>
	
	/** 
	* setter  and  getter
	**/
	<#list metaDataList as metaData>
	
		<#if metaData.variableType == "java.util.Date">
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
		</#if>
		public ${metaData.variableType} get${metaData.fuFieldName}(){
			return ${metaData.fieldName};
		}
		
		public void set${metaData.fuFieldName}(${metaData.variableType} ${metaData.fieldName}){
			this.${metaData.fieldName}=${metaData.fieldName};
		}
	</#list>
}