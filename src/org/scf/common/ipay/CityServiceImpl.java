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
public class CityServiceImpl implements CityService {

	@Autowired
	CityDao cityDao;
	
	public CityBean insert(CityBean cityBean) {
		return cityDao.insert(cityBean);
	}
	public int update(CityBean cityBean) {
		return cityDao.update(cityBean);
	}
	public int delete(int id) {
		return cityDao.delete(id);
	}
	public List<CityBean> findByPrimaryKey(int id) {
		return cityDao.findByPrimaryKey(id);
	}
	public List<CityBean> findAllByPage(CityBean cityBean, int start, int detla) {
		return cityDao.findAllByPage(cityBean, start, detla);
	}
	public int findAllCount(CityBean cityBean) {
		return cityDao.findAllCount(cityBean);
	}
}
