package org.youme.Device_core.service;

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface EquipmentsendreceivegroupmapService {
	/**
	 * 新增记录
	 * @param equipmentsendreceivegroupmap
	 * @return
	 */
	public EquipmentsendreceivegroupmapBean insert(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean);
	/**
	 * 更新
	 * @param equipmentsendreceivegroupmapBean
	 * @return
	 */
	public int update(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean);
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
	public List<EquipmentsendreceivegroupmapBean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param equipmentsendreceivegroupmapBean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<EquipmentsendreceivegroupmapBean> findAllByPage(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean,int start,int detla);
	
	/**
	 * 记录总条数
	 * @param equipmentsendreceivegroupmapBean
	 * @return
	 */
	public int findAllCount(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean);
	
}
