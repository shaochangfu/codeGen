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
public class EquipmentsenddeviceServiceImpl implements EquipmentsenddeviceService {

	@Autowired
	EquipmentsenddeviceDao equipmentsenddeviceDao;
	
	public EquipmentsenddeviceBean insert(EquipmentsenddeviceBean equipmentsenddeviceBean) {
		return equipmentsenddeviceDao.insert(equipmentsenddeviceBean);
	}
	public int update(EquipmentsenddeviceBean equipmentsenddeviceBean) {
		return equipmentsenddeviceDao.update(equipmentsenddeviceBean);
	}
	public int delete(int id) {
		return equipmentsenddeviceDao.delete(id);
	}
	public List<EquipmentsenddeviceBean> findByPrimaryKey(int id) {
		return equipmentsenddeviceDao.findByPrimaryKey(id);
	}
	public List<EquipmentsenddeviceBean> findAllByPage(EquipmentsenddeviceBean equipmentsenddeviceBean, int start, int detla) {
		return equipmentsenddeviceDao.findAllByPage(equipmentsenddeviceBean, start, detla);
	}
	public int findAllCount(EquipmentsenddeviceBean equipmentsenddeviceBean) {
		return equipmentsenddeviceDao.findAllCount(equipmentsenddeviceBean);
	}
}
