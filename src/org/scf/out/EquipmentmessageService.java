package org.youme.Device_core.service;

import org.youme.dbcacherouter.EActionStatus;
import org.youme.dbcacherouter.mybatis.FindResult;
import java.util.HashMap;

/**
**/
public interface EquipmentmessageService{
	/**
	 * */
	public EActionStatus addEquipmentmessage(EquipmentmessageBean equipmentmessageBean); 
	/**
	 * */
	public EActionStatus delEquipmentmessage(EquipmentmessageBeanExample beanExample);
	/**
	 * */
	public EActionStatus updateEquipmentmessage(EquipmentmessageBean equipmentmessageBean,EquipmentmessageBeanExample beanExample);
	
	/**
	 */
	public EquipmentmessageBean findEquipmentmessageByPK(EquipmentmessageBeanExample beanExample);
	/**
	 */
	public FindResult findEquipmentmessageByPage(HashMap map);
}