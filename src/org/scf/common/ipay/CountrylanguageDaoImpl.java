package org.scf.common.ipay.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class CountrylanguageDaoImpl extends SqlMapClientDaoSupport implements CountrylanguageDao{
	
	private static final String NAMESPACE3 = "countrylanguage.";

	@Autowired
	@Qualifier("sqlMapClient1")
	public void injectSqlMapClient(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}
	
	public List findCheckMerchantByInstitutionCode(String institutionCode) {
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findCheckMerchantByInstitutionCode", institutionCode);
	}

	public CountrylanguageBean insert(CountrylanguageBean countrylanguageBean) {
		return (CountrylanguageBean)getSqlMapClientTemplate().insert(NAMESPACE3+"insert", countrylanguageBean);
	}

	public int update(CountrylanguageBean countrylanguageBean) {
		return getSqlMapClientTemplate().update(NAMESPACE3+"update",countrylanguageBean);
	}

	public int delete(int id) {
		return getSqlMapClientTemplate().delete(NAMESPACE3+"delete", id);
	}

	public List<CountrylanguageBean> findByPrimaryKey(int id) {
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findByPrimaryKey", id);
	}
	
	public List<CountrylanguageBean> findAllByPage(CountrylanguageBean countrylanguageBean,int start,int detla) {
		countrylanguageBean.setDetla(detla);
		countrylanguageBean.setStart(start);
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findAllByPage", countrylanguageBean,start,detla);
	}
	
	public int findAllCount(CountrylanguageBean countrylanguageBean){
		return (Integer)getSqlMapClientTemplate().queryForObject(NAMESPACE3+"findAllCount", countrylanguageBean);
	}
}
