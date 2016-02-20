package org.scf.common.ipay.bean;

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface CountryService {
	/**
	 * 新增记录
	 * @param country
	 * @return
	 */
	public CountryBean insert(CountryBean countryBean);
	/**
	 * 更新
	 * @param countryBean
	 * @return
	 */
	public int update(CountryBean countryBean);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 根据主键查找
	 * @param id
	 * @return
	 */
	public List<CountryBean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param countryBean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<CountryBean> findAllByPage(CountryBean countryBean,int start,int detla);
	
	/**
	 * 记录总条数
	 * @param countryBean
	 * @return
	 */
	public int findAllCount(CountryBean countryBean);
	
}
