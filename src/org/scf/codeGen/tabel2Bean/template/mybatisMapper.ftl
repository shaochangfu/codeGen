<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE sqlMap
		PUBLIC "-//iBATIS.com//DTD SQL Map 2.0//EN"
		"http://ibatis.apache.org/dtd/sql-map-2.dtd">

<sqlMap namespace="${beanName}">
	
	<typeAlias alias="${beanName}" type="org.webutils.${beanName}.${beanNameClass}Bean"/>
	
	<resultMap id="result" class="org.webutils.${beanName}.${beanNameClass}Bean">
		<#list metaDataList as metaData>
			<result property="${metaData.fieldName}" column="${metaData.fieldName}" columnIndex="${metaData_index+1}"/>
		</#list>
	</resultMap>
	
	<!-- 插入  -->
	<insert id="insert" parameterClass="org.webutils.${beanName}.${beanNameClass}Bean" >
		insert into ${beanName}
		(
		<#list metaDataList as metaData>
			${metaData.fieldName}<#if metaData_has_next>,</#if>
		</#list>
		) 
		values 
		(
		<#list metaDataList as metaData>
			#${metaData.fieldName}#<#if metaData_has_next>,</#if>
		</#list>
		);
	</insert>
	
	<!-- 修改 -->
	<update id="update" parameterClass="${beanName}" > 
		update ${beanName} set 
		<#list metaDataList as metaData>
			${metaData.fieldName} = #${metaData.fieldName}# <#if metaData_has_next>,</#if>
		</#list>
		 where id = #id#;
	</update>
	
	<!-- 删除 -->
	
	<!-- 主键查询 -->
	<select id="findByPrimaryKey" parameterClass="java.lang.String" resultMap="result">
		select * from ${beanName} p where p.id = #id# ;
	</select>
	
	<!-- 分页查询 -->
	<select id="findAllByPage" parameterClass="${beanName}" resultClass="${beanName}">
		select 
			<#list metaDataList as metaData>
				p.${metaData.fieldName}<#if metaData_has_next>,</#if>
			</#list>
		 from ${beanName} p where 1=1
		<#list metaDataList as metaData>
			<isNotEmpty prepend="AND" property="${metaData.fieldName}">
				 p.${metaData.fieldName} = #${metaData.fieldName}#
		 	</isNotEmpty>
		 </#list>
		 limit #start#,#detla# ;
	</select>
	
	<!-- 总记录数-->
	<select id="findAllCount" parameterClass="${beanName}" resultClass="java.lang.Integer">
		select 
			count(*) 
		 from ${beanName} p where 1=1
		<#list metaDataList as metaData>
			<isNotEmpty prepend="AND" property="${metaData.fieldName}">
				 p.${metaData.fieldName} = #${metaData.fieldName}#
		 	</isNotEmpty>
		 </#list>
		 limit #start#,#detla# ;
	</select>
</sqlMap>