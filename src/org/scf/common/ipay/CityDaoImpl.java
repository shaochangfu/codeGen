package org.scf.common.ipay.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class CityDaoImpl extends SqlMapClientDaoSupport implements CityDao{
	
	private static final String NAMESPACE3 = "city.";

	@Autowired
	@Qualifier("sqlMapClient1")
	public void injectSqlMapClient(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
	}
	
	public List findCheckMerchantByInstitutionCode(String institutionCode) {
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findCheckMerchantByInstitutionCode", institutionCode);
	}

	public CityBean insert(CityBean cityBean) {
		return (CityBean)getSqlMapClientTemplate().insert(NAMESPACE3+"insert", cityBean);
	}

	public int update(CityBean cityBean) {
		return getSqlMapClientTemplate().update(NAMESPACE3+"update",cityBean);
	}

	public int delete(int id) {
		return getSqlMapClientTemplate().delete(NAMESPACE3+"delete", id);
	}

	public List<CityBean> findByPrimaryKey(int id) {
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findByPrimaryKey", id);
	}
	
	public List<CityBean> findAllByPage(CityBean cityBean,int start,int detla) {
		cityBean.setDetla(detla);
		cityBean.setStart(start);
		return getSqlMapClientTemplate().queryForList(NAMESPACE3+"findAllByPage", cityBean,start,detla);
	}
	
	public int findAllCount(CityBean cityBean){
		return (Integer)getSqlMapClientTemplate().queryForObject(NAMESPACE3+"findAllCount", cityBean);
	}
}
