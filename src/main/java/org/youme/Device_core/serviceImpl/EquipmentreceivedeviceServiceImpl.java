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
public class EquipmentreceivedeviceServiceImpl implements EquipmentreceivedeviceService {

	@Autowired
	EquipmentreceivedeviceDao equipmentreceivedeviceDao;
	
	public EquipmentreceivedeviceBean insert(EquipmentreceivedeviceBean equipmentreceivedeviceBean) {
		return equipmentreceivedeviceDao.insert(equipmentreceivedeviceBean);
	}
	public int update(EquipmentreceivedeviceBean equipmentreceivedeviceBean) {
		return equipmentreceivedeviceDao.update(equipmentreceivedeviceBean);
	}
	public int delete(int id) {
		return equipmentreceivedeviceDao.delete(id);
	}
	public List<EquipmentreceivedeviceBean> findByPrimaryKey(int id) {
		return equipmentreceivedeviceDao.findByPrimaryKey(id);
	}
	public List<EquipmentreceivedeviceBean> findAllByPage(EquipmentreceivedeviceBean equipmentreceivedeviceBean, int start, int detla) {
		return equipmentreceivedeviceDao.findAllByPage(equipmentreceivedeviceBean, start, detla);
	}
	public int findAllCount(EquipmentreceivedeviceBean equipmentreceivedeviceBean) {
		return equipmentreceivedeviceDao.findAllCount(equipmentreceivedeviceBean);
	}
}
