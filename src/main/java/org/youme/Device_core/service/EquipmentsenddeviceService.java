package org.youme.Device_core.service;

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface EquipmentsenddeviceService {
	/**
	 * 新增记录
	 * @param equipmentsenddevice
	 * @return
	 */
	public EquipmentsenddeviceBean insert(EquipmentsenddeviceBean equipmentsenddeviceBean);
	/**
	 * 更新
	 * @param equipmentsenddeviceBean
	 * @return
	 */
	public int update(EquipmentsenddeviceBean equipmentsenddeviceBean);
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
	public List<EquipmentsenddeviceBean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param equipmentsenddeviceBean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<EquipmentsenddeviceBean> findAllByPage(EquipmentsenddeviceBean equipmentsenddeviceBean,int start,int detla);
	
	/**
	 * 记录总条数
	 * @param equipmentsenddeviceBean
	 * @return
	 */
	public int findAllCount(EquipmentsenddeviceBean equipmentsenddeviceBean);
	
}
