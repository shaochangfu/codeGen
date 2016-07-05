package org.youme.Device_core.service;

import org.youme.dbcacherouter.EActionStatus;
import org.youme.dbcacherouter.mybatis.FindResult;
import java.util.HashMap;

/**
**/
public interface EquipmentroomService{
	/**
	 * */
	public EActionStatus addEquipmentroom(EquipmentroomBean equipmentroomBean); 
	/**
	 * */
	public EActionStatus delEquipmentroom(EquipmentroomBeanExample beanExample);
	/**
	 * */
	public EActionStatus updateEquipmentroom(EquipmentroomBean equipmentroomBean,EquipmentroomBeanExample beanExample);
	
	/**
	 */
	public EquipmentroomBean findEquipmentroomByPK(EquipmentroomBeanExample beanExample);
	/**
	 */
	public FindResult findEquipmentroomByPage(HashMap map);
}