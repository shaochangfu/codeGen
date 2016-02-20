package org.scf.common.ipay.bean;

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface CityDao {
	
	/**
	 * 新增记录
	 * @param cityBean
	 * @return
	 */
	public CityBean insert(CityBean cityBean);
	/**
	 * 更新
	 * @param cityBean
	 * @return
	 */
	public int update(CityBean cityBean);
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
	public List<CityBean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param cityBean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<CityBean> findAllByPage(CityBean cityBean,int start,int detla);
	
	/**
	 * 查询总条数
	 * @param cityBean
	 * @return
	 */
	public int findAllCount(CityBean cityBean);
}
