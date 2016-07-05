package ${packageName};

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
**/
public class ${beanNameClass}BeanExample {

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ${beanNameClass}BeanExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}
		
		<#list metaDataList as metaData>
		public Criteria and${metaData.fuFieldName}IsNull() {
			addCriterion("${metaData.fieldName} is null");
			return (Criteria) this;
		}
		
		public Criteria and${metaData.fuFieldName}IsNotNull() {
			addCriterion("${metaData.fieldName} is not null");
			return (Criteria) this;
		}
		
		public Criteria and${metaData.fuFieldName}EqualTo(${metaData.variableType} value) {
			addCriterion("${metaData.fieldName} =", value, "${metaData.fieldName}");
			return (Criteria) this;
		}
		
		public Criteria and${metaData.fuFieldName}NotEqualTo(${metaData.variableType} value) {
			addCriterion("${metaData.fieldName} <>", value, "${metaData.fieldName}");
			return (Criteria) this;
		}
		
		public Criteria and${metaData.fuFieldName}GreaterThan(${metaData.variableType} value) {
			addCriterion("${metaData.fieldName} >", value, "${metaData.fieldName}");
			return (Criteria) this;
		}
		
		public Criteria and${metaData.fuFieldName}GreaterThanOrEqualTo(${metaData.variableType} value) {
			addCriterion("${metaData.fieldName} >=", value, "${metaData.fieldName}");
			return (Criteria) this;
		}
		
		public Criteria and${metaData.fuFieldName}LessThan(${metaData.variableType} value) {
			addCriterion("${metaData.fieldName} <", value, "${metaData.fieldName}");
			return (Criteria) this;
		}
		
		public Criteria and${metaData.fuFieldName}LessThanOrEqualTo(${metaData.variableType} value) {
			addCriterion("${metaData.fieldName} <=", value, "${metaData.fieldName}");
			return (Criteria) this;
		}
		
		public Criteria and${metaData.fuFieldName}In(List<${metaData.variableType}> values) {
			addCriterion("${metaData.fieldName} in", values, "${metaData.fieldName}");
			return (Criteria) this;
		}

		public Criteria and${metaData.fuFieldName}NotIn(List<${metaData.variableType}> values) {
			addCriterion("${metaData.fieldName} not in", values, "${metaData.fieldName}");
			return (Criteria) this;
		}

		public Criteria and${metaData.fuFieldName}Between(${metaData.variableType} value1, ${metaData.variableType} value2) {
			addCriterion("${metaData.fieldName} between", value1, value2, "${metaData.fieldName}");
			return (Criteria) this;
		}

		public Criteria and${metaData.fuFieldName}NotBetween(${metaData.variableType} value1, ${metaData.variableType} value2) {
			addCriterion("${metaData.fieldName} not between", value1, value2, "${metaData.fieldName}");
			return (Criteria) this;
		}
		
		
		<#if metaData.variableType == "String">
		public Criteria and${metaData.fuFieldName}Like(${metaData.variableType} value) {
			addCriterion("${metaData.fieldName} like", value, "${metaData.fieldName}");
			return (Criteria) this;
		}

		public Criteria and${metaData.fuFieldName}NotLike(${metaData.variableType} value) {
			addCriterion("${metaData.fieldName} not like", value, "${metaData.fieldName}");
			return (Criteria) this;
		}
		</#if>
		</#list>
	}
	
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
		

}