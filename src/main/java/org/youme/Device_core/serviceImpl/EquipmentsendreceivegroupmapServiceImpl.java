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
public class EquipmentsendreceivegroupmapServiceImpl implements EquipmentsendreceivegroupmapService {

	@Autowired
	EquipmentsendreceivegroupmapDao equipmentsendreceivegroupmapDao;
	
	public EquipmentsendreceivegroupmapBean insert(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean) {
		return equipmentsendreceivegroupmapDao.insert(equipmentsendreceivegroupmapBean);
	}
	public int update(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean) {
		return equipmentsendreceivegroupmapDao.update(equipmentsendreceivegroupmapBean);
	}
	public int delete(int id) {
		return equipmentsendreceivegroupmapDao.delete(id);
	}
	public List<EquipmentsendreceivegroupmapBean> findByPrimaryKey(int id) {
		return equipmentsendreceivegroupmapDao.findByPrimaryKey(id);
	}
	public List<EquipmentsendreceivegroupmapBean> findAllByPage(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean, int start, int detla) {
		return equipmentsendreceivegroupmapDao.findAllByPage(equipmentsendreceivegroupmapBean, start, detla);
	}
	public int findAllCount(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean) {
		return equipmentsendreceivegroupmapDao.findAllCount(equipmentsendreceivegroupmapBean);
	}
}
