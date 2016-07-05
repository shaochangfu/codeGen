package org.youme.Device_core.service;

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface EquipmentroomService {
	/**
	 * 新增记录
	 * @param equipmentroom
	 * @return
	 */
	public EquipmentroomBean insert(EquipmentroomBean equipmentroomBean);
	/**
	 * 更新
	 * @param equipmentroomBean
	 * @return
	 */
	public int update(EquipmentroomBean equipmentroomBean);
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
	public List<EquipmentroomBean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param equipmentroomBean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<EquipmentroomBean> findAllByPage(EquipmentroomBean equipmentroomBean,int start,int detla);
	
	/**
	 * 记录总条数
	 * @param equipmentroomBean
	 * @return
	 */
	public int findAllCount(EquipmentroomBean equipmentroomBean);
	
}
