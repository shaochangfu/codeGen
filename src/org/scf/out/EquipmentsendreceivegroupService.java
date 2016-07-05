package org.youme.Device_core.service;

import org.youme.dbcacherouter.EActionStatus;
import org.youme.dbcacherouter.mybatis.FindResult;
import java.util.HashMap;

/**
**/
public interface EquipmentsendreceivegroupService{
	/**
	 * */
	public EActionStatus addEquipmentsendreceivegroup(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean); 
	/**
	 * */
	public EActionStatus delEquipmentsendreceivegroup(EquipmentsendreceivegroupBeanExample beanExample);
	/**
	 * */
	public EActionStatus updateEquipmentsendreceivegroup(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean,EquipmentsendreceivegroupBeanExample beanExample);
	
	/**
	 */
	public EquipmentsendreceivegroupBean findEquipmentsendreceivegroupByPK(EquipmentsendreceivegroupBeanExample beanExample);
	/**
	 */
	public FindResult findEquipmentsendreceivegroupByPage(HashMap map);
}