package ${packageName};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ${beanNameClass}DaoImpl extends SqlMapClientDaoSupport implements ${beanNameClass}Dao{
	
	private static final String NAMESPACE3 = "${beanName}.";

	@Autowired
	@Qualifier("sqlMapClient1")
	public void injectSqlMapClient(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}
	
	public List findCheckMerchantByInstitutionCode(String institutionCode) {
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findCheckMerchantByInstitutionCode", institutionCode);
	}

	public ${beanNameClass}Bean insert(${beanNameClass}Bean ${beanName}Bean) {
		return (${beanNameClass}Bean)getSqlMapClientTemplate().insert(NAMESPACE3+"insert", ${beanName}Bean);
	}

	public int update(${beanNameClass}Bean ${beanName}Bean) {
		return getSqlMapClientTemplate().update(NAMESPACE3+"update",${beanName}Bean);
	}

	public int delete(int id) {
		return getSqlMapClientTemplate().delete(NAMESPACE3+"delete", id);
	}

	public List<${beanNameClass}Bean> findByPrimaryKey(int id) {
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findByPrimaryKey", id);
	}
	
	public List<${beanNameClass}Bean> findAllByPage(${beanNameClass}Bean ${beanName}Bean,int start,int detla) {
		${beanName}.setDetla(detla);
		${beanName}.setStart(start);
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findAllByPage", ${beanName}Bean,start,detla);
	}
	
}
