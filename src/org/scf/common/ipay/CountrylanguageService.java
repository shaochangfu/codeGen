package org.scf.common.ipay.bean;

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface CountrylanguageService {
	/**
	 * 新增记录
	 * @param countrylanguage
	 * @return
	 */
	public CountrylanguageBean insert(CountrylanguageBean countrylanguageBean);
	/**
	 * 更新
	 * @param countrylanguageBean
	 * @return
	 */
	public int update(CountrylanguageBean countrylanguageBean);
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
	public List<CountrylanguageBean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param countrylanguageBean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<CountrylanguageBean> findAllByPage(CountrylanguageBean countrylanguageBean,int start,int detla);
	
	/**
	 * 记录总条数
	 * @param countrylanguageBean
	 * @return
	 */
	public int findAllCount(CountrylanguageBean countrylanguageBean);
	
}
