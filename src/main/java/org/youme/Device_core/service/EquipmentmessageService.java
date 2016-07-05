package org.youme.Device_core.service;

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface EquipmentmessageService {
	/**
	 * 新增记录
	 * @param equipmentmessage
	 * @return
	 */
	public EquipmentmessageBean insert(EquipmentmessageBean equipmentmessageBean);
	/**
	 * 更新
	 * @param equipmentmessageBean
	 * @return
	 */
	public int update(EquipmentmessageBean equipmentmessageBean);
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
	public List<EquipmentmessageBean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param equipmentmessageBean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<EquipmentmessageBean> findAllByPage(EquipmentmessageBean equipmentmessageBean,int start,int detla);
	
	/**
	 * 记录总条数
	 * @param equipmentmessageBean
	 * @return
	 */
	public int findAllCount(EquipmentmessageBean equipmentmessageBean);
	
}
