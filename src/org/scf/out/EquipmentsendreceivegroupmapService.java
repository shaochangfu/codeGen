package org.youme.Device_core.service;

import org.youme.dbcacherouter.EActionStatus;
import org.youme.dbcacherouter.mybatis.FindResult;
import java.util.HashMap;

/**
**/
public interface EquipmentsendreceivegroupmapService{
	/**
	 * */
	public EActionStatus addEquipmentsendreceivegroupmap(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean); 
	/**
	 * */
	public EActionStatus delEquipmentsendreceivegroupmap(EquipmentsendreceivegroupmapBeanExample beanExample);
	/**
	 * */
	public EActionStatus updateEquipmentsendreceivegroupmap(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean,EquipmentsendreceivegroupmapBeanExample beanExample);
	
	/**
	 */
	public EquipmentsendreceivegroupmapBean findEquipmentsendreceivegroupmapByPK(EquipmentsendreceivegroupmapBeanExample beanExample);
	/**
	 */
	public FindResult findEquipmentsendreceivegroupmapByPage(HashMap map);
}