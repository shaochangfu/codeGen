package org.youme.Device_core.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author scf
 *
 */
@Service
public class EquipmentmessageServiceImpl implements EquipmentmessageService {

	@Autowired
	EquipmentmessageDao equipmentmessageDao;
	
	public EquipmentmessageBean insert(EquipmentmessageBean equipmentmessageBean) {
		return equipmentmessageDao.insert(equipmentmessageBean);
	}
	public int update(EquipmentmessageBean equipmentmessageBean) {
		return equipmentmessageDao.update(equipmentmessageBean);
	}
	public int delete(int id) {
		return equipmentmessageDao.delete(id);
	}
	public List<EquipmentmessageBean> findByPrimaryKey(int id) {
		return equipmentmessageDao.findByPrimaryKey(id);
	}
	public List<EquipmentmessageBean> findAllByPage(EquipmentmessageBean equipmentmessageBean, int start, int detla) {
		return equipmentmessageDao.findAllByPage(equipmentmessageBean, start, detla);
	}
	public int findAllCount(EquipmentmessageBean equipmentmessageBean) {
		return equipmentmessageDao.findAllCount(equipmentmessageBean);
	}
}
