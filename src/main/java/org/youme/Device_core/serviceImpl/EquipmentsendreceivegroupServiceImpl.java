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
public class EquipmentsendreceivegroupServiceImpl implements EquipmentsendreceivegroupService {

	@Autowired
	EquipmentsendreceivegroupDao equipmentsendreceivegroupDao;
	
	public EquipmentsendreceivegroupBean insert(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean) {
		return equipmentsendreceivegroupDao.insert(equipmentsendreceivegroupBean);
	}
	public int update(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean) {
		return equipmentsendreceivegroupDao.update(equipmentsendreceivegroupBean);
	}
	public int delete(int id) {
		return equipmentsendreceivegroupDao.delete(id);
	}
	public List<EquipmentsendreceivegroupBean> findByPrimaryKey(int id) {
		return equipmentsendreceivegroupDao.findByPrimaryKey(id);
	}
	public List<EquipmentsendreceivegroupBean> findAllByPage(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean, int start, int detla) {
		return equipmentsendreceivegroupDao.findAllByPage(equipmentsendreceivegroupBean, start, detla);
	}
	public int findAllCount(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean) {
		return equipmentsendreceivegroupDao.findAllCount(equipmentsendreceivegroupBean);
	}
}
