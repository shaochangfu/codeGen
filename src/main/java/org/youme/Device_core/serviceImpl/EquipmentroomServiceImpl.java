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
public class EquipmentroomServiceImpl implements EquipmentroomService {

	@Autowired
	EquipmentroomDao equipmentroomDao;
	
	public EquipmentroomBean insert(EquipmentroomBean equipmentroomBean) {
		return equipmentroomDao.insert(equipmentroomBean);
	}
	public int update(EquipmentroomBean equipmentroomBean) {
		return equipmentroomDao.update(equipmentroomBean);
	}
	public int delete(int id) {
		return equipmentroomDao.delete(id);
	}
	public List<EquipmentroomBean> findByPrimaryKey(int id) {
		return equipmentroomDao.findByPrimaryKey(id);
	}
	public List<EquipmentroomBean> findAllByPage(EquipmentroomBean equipmentroomBean, int start, int detla) {
		return equipmentroomDao.findAllByPage(equipmentroomBean, start, detla);
	}
	public int findAllCount(EquipmentroomBean equipmentroomBean) {
		return equipmentroomDao.findAllCount(equipmentroomBean);
	}
}
