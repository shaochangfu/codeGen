package org.scf.common.ipay.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class CountryDaoImpl extends SqlMapClientDaoSupport implements CountryDao{
	
	private static final String NAMESPACE3 = "country.";

	@Autowired
	@Qualifier("sqlMapClient1")
	public void injectSqlMapClient(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}
	
	public List findCheckMerchantByInstitutionCode(String institutionCode) {
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findCheckMerchantByInstitutionCode", institutionCode);
	}

	public CountryBean insert(CountryBean countryBean) {
		return (CountryBean)getSqlMapClientTemplate().insert(NAMESPACE3+"insert", countryBean);
	}

	public int update(CountryBean countryBean) {
		return getSqlMapClientTemplate().update(NAMESPACE3+"update",countryBean);
	}

	public int delete(int id) {
		return getSqlMapClientTemplate().delete(NAMESPACE3+"delete", id);
	}

	public List<CountryBean> findByPrimaryKey(int id) {
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findByPrimaryKey", id);
	}
	
	public List<CountryBean> findAllByPage(CountryBean countryBean,int start,int detla) {
		countryBean.setDetla(detla);
		countryBean.setStart(start);
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findAllByPage", countryBean,start,detla);
	}
	
	public int findAllCount(CountryBean countryBean){
		return (Integer)getSqlMapClientTemplate().queryForObject(NAMESPACE3+"findAllCount", countryBean);
	}
}
