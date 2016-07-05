<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${packageName}.${beanNameClass}BeanMapper" >

<resultMap id="BaseResultMap" type="${packageName}.${beanNameClass}Bean" >
<#list metaDataList as metaData>
	<result property="${metaData.fieldName}" column="${metaData.fieldName}" jdbcType="${metaData.jdbcType}" />
</#list>
  </resultMap>
  <sql id="Example_Where_Clause" >
    <where >
      <foreach collection="oredCriteria" item="criteria" separator="or" >
        <if test="criteria.valid" >
          <trim prefix="(" suffix=")" prefixOverrides="and" >
            <foreach collection="criteria.criteria" item="criterion" >
              <choose >
                <when test="criterion.noValue" >
                  and $\{criterion.condition}
                </when>
                <when test="criterion.singleValue" >
                  and $\{criterion.condition} #\{criterion.value}
                </when>
                <when test="criterion.betweenValue" >
                  and $\{criterion.condition} #\{criterion.value} and #\{criterion.secondValue}
                </when>
                <when test="criterion.listValue" >
                  and $\{criterion.condition}
                  <foreach collection="criterion.value" item="listItem" open="(" close=")" separator="," >
                    #\{listItem}
                  </foreach>
                </when>
              </choose>
            </foreach>
          </trim>
        </if>
      </foreach>
    </where>
  </sql>
  <sql id="Update_By_Example_Where_Clause" >
    <where >
      <foreach collection="example.oredCriteria" item="criteria" separator="or" >
        <if test="criteria.valid" >
          <trim prefix="(" suffix=")" prefixOverrides="and" >
            <foreach collection="criteria.criteria" item="criterion" >
              <choose >
                <when test="criterion.noValue" >
                  and $\{criterion.condition}
                </when>
                <when test="criterion.singleValue" >
                  and $\{criterion.condition} #\{criterion.value}
                </when>
                <when test="criterion.betweenValue" >
                  and $\{criterion.condition} #\{criterion.value} and #\{criterion.secondValue}
                </when>
                <when test="criterion.listValue" >
                  and $\{criterion.condition}
                  <foreach collection="criterion.value" item="listItem" open="(" close=")" separator="," >
                    #\{listItem}
                  </foreach>
                </when>
              </choose>
            </foreach>
          </trim>
        </if>
      </foreach>
    </where>
  </sql>
  <sql id="Base_Column_List" >
	<#list metaDataList as metaData>
		${metaData.fieldName} <#if metaData_has_next>,</#if>
	</#list>
  </sql>
  <select id="selectByExample" resultMap="BaseResultMap" parameterType="${packageName}.${beanNameClass}BeanExample" >
    select
    <if test="distinct" >
      distinct
    </if>
    <include refid="Base_Column_List" />
    from ${tableName}
    <if test="_parameter != null" >
      <include refid="Example_Where_Clause" />
    </if>
    <if test="orderByClause != null" >
      order by $\{orderByClause}
    </if>
  </select>
  <delete id="deleteByExample" parameterType="${packageName}.${beanNameClass}BeanExample" >
    delete from ${tableName}
    <if test="_parameter != null" >
      <include refid="Example_Where_Clause" />
    </if>
  </delete>
  <insert id="insert" parameterType="${packageName}.${beanNameClass}Bean" >
    insert into ${tableName} (
		<#list metaDataList as metaData>
			${metaData.fieldName} <#if metaData_has_next>,</#if>
		</#list>
    )
    values (
    <#list metaDataList as metaData>
		#\{${metaData.fieldName},jdbcType=${metaData.jdbcType}}<#if metaData_has_next>,</#if>
	</#list>
  	)
  </insert>
  <insert id="insertSelective" parameterType="${packageName}.${beanNameClass}Bean" >
    insert into ${tableName}
    <trim prefix="(" suffix=")" suffixOverrides="," >
    
    	<#list metaDataList as metaData>
    		<if test="${metaData.fieldName} != null" >
				${metaData.fieldName}<#if metaData_has_next>,</#if>
			</if>
		</#list>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides="," >
    
    	<#list metaDataList as metaData>
    		<if test="${metaData.fieldName} != null" >
				#\{${metaData.fieldName},jdbcType=${metaData.jdbcType}}<#if metaData_has_next>,</#if>
			</if>
		</#list>
	</trim>
  </insert>
  <select id="countByExample" parameterType="${packageName}.${beanNameClass}BeanExample" resultType="java.lang.Integer" >
    select count(*) from ${tableName}
    <if test="_parameter != null" >
      <include refid="Example_Where_Clause" />
    </if>
  </select>
  <update id="updateByExampleSelective" parameterType="map" >
    update ${tableName}
    <set >
    	<#list metaDataList as metaData>
    		<if test="record.${metaData.fieldName} != null" >
				${metaData.fieldName} = #\{record.${metaData.fieldName},jdbcType=${metaData.jdbcType}}<#if metaData_has_next>,</#if>
			</if>
		</#list>
    </set>
    <if test="_parameter != null" >
      <include refid="Update_By_Example_Where_Clause" />
    </if>
  </update>
  <update id="updateByExample" parameterType="map" >
    update ${tableName}
    set 
	<#list metaDataList as metaData>
			${metaData.fieldName} = #\{record.${metaData.fieldName},jdbcType=${metaData.jdbcType}}<#if metaData_has_next>,</#if>
	</#list>
    <if test="_parameter != null" >
      <include refid="Update_By_Example_Where_Clause" />
    </if>
  </update>
</mapper>