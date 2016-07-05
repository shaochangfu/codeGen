package org.youme.Device_core.service;

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface EquipmentsendreceivegroupService {
	/**
	 * 新增记录
	 * @param equipmentsendreceivegroup
	 * @return
	 */
	public EquipmentsendreceivegroupBean insert(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean);
	/**
	 * 更新
	 * @param equipmentsendreceivegroupBean
	 * @return
	 */
	public int update(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean);
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
	public List<EquipmentsendreceivegroupBean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param equipmentsendreceivegroupBean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<EquipmentsendreceivegroupBean> findAllByPage(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean,int start,int detla);
	
	/**
	 * 记录总条数
	 * @param equipmentsendreceivegroupBean
	 * @return
	 */
	public int findAllCount(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean);
	
}
