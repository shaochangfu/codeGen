package org.youme.Device_core.service;

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface EquipmentreceivedeviceService {
	/**
	 * 新增记录
	 * @param equipmentreceivedevice
	 * @return
	 */
	public EquipmentreceivedeviceBean insert(EquipmentreceivedeviceBean equipmentreceivedeviceBean);
	/**
	 * 更新
	 * @param equipmentreceivedeviceBean
	 * @return
	 */
	public int update(EquipmentreceivedeviceBean equipmentreceivedeviceBean);
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
	public List<EquipmentreceivedeviceBean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param equipmentreceivedeviceBean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<EquipmentreceivedeviceBean> findAllByPage(EquipmentreceivedeviceBean equipmentreceivedeviceBean,int start,int detla);
	
	/**
	 * 记录总条数
	 * @param equipmentreceivedeviceBean
	 * @return
	 */
	public int findAllCount(EquipmentreceivedeviceBean equipmentreceivedeviceBean);
	
}
