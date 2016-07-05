package org.youme.Device_core.service;

import org.youme.dbcacherouter.EActionStatus;
import org.youme.dbcacherouter.mybatis.FindResult;
import java.util.HashMap;

/**
**/
public interface EquipmentsenddeviceService{
	/**
	 * */
	public EActionStatus addEquipmentsenddevice(EquipmentsenddeviceBean equipmentsenddeviceBean); 
	/**
	 * */
	public EActionStatus delEquipmentsenddevice(EquipmentsenddeviceBeanExample beanExample);
	/**
	 * */
	public EActionStatus updateEquipmentsenddevice(EquipmentsenddeviceBean equipmentsenddeviceBean,EquipmentsenddeviceBeanExample beanExample);
	
	/**
	 */
	public EquipmentsenddeviceBean findEquipmentsenddeviceByPK(EquipmentsenddeviceBeanExample beanExample);
	/**
	 */
	public FindResult findEquipmentsenddeviceByPage(HashMap map);
}