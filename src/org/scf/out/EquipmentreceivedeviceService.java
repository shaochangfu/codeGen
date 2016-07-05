package org.youme.Device_core.service;

import org.youme.dbcacherouter.EActionStatus;
import org.youme.dbcacherouter.mybatis.FindResult;
import java.util.HashMap;

/**
**/
public interface EquipmentreceivedeviceService{
	/**
	 * */
	public EActionStatus addEquipmentreceivedevice(EquipmentreceivedeviceBean equipmentreceivedeviceBean); 
	/**
	 * */
	public EActionStatus delEquipmentreceivedevice(EquipmentreceivedeviceBeanExample beanExample);
	/**
	 * */
	public EActionStatus updateEquipmentreceivedevice(EquipmentreceivedeviceBean equipmentreceivedeviceBean,EquipmentreceivedeviceBeanExample beanExample);
	
	/**
	 */
	public EquipmentreceivedeviceBean findEquipmentreceivedeviceByPK(EquipmentreceivedeviceBeanExample beanExample);
	/**
	 */
	public FindResult findEquipmentreceivedeviceByPage(HashMap map);
}