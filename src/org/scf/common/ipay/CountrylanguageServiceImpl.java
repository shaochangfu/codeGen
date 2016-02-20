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
public class CountrylanguageServiceImpl implements CountrylanguageService {

	@Autowired
	CountrylanguageDao countrylanguageDao;
	
	public CountrylanguageBean insert(CountrylanguageBean countrylanguageBean) {
		return countrylanguageDao.insert(countrylanguageBean);
	}
	public int update(CountrylanguageBean countrylanguageBean) {
		return countrylanguageDao.update(countrylanguageBean);
	}
	public int delete(int id) {
		return countrylanguageDao.delete(id);
	}
	public List<CountrylanguageBean> findByPrimaryKey(int id) {
		return countrylanguageDao.findByPrimaryKey(id);
	}
	public List<CountrylanguageBean> findAllByPage(CountrylanguageBean countrylanguageBean, int start, int detla) {
		return countrylanguageDao.findAllByPage(countrylanguageBean, start, detla);
	}
	public int findAllCount(CountrylanguageBean countrylanguageBean) {
		return countrylanguageDao.findAllCount(countrylanguageBean);
	}
}
