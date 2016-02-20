package org.scf.common.ipay.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author scf
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryDao countryDao;
	
	public CountryBean insert(CountryBean countryBean) {
		return countryDao.insert(countryBean);
	}
	public int update(CountryBean countryBean) {
		return countryDao.update(countryBean);
	}
	public int delete(int id) {
		return countryDao.delete(id);
	}
	public List<CountryBean> findByPrimaryKey(int id) {
		return countryDao.findByPrimaryKey(id);
	}
	public List<CountryBean> findAllByPage(CountryBean countryBean, int start, int detla) {
		return countryDao.findAllByPage(countryBean, start, detla);
	}
	public int findAllCount(CountryBean countryBean) {
		return countryDao.findAllCount(countryBean);
	}
}
