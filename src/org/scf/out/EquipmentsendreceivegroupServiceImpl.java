package org.youme.Device_core.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.youme.dbcacherouter.EActionStatus;
import org.youme.dbcacherouter.mybatis.EntityDao;
import org.youme.dbcacherouter.mybatis.FindResult;


/**
 * 
 * @author scf
 *
 */
@Service("equipmentsendreceivegroupService")
public class EquipmentsendreceivegroupServiceImpl implements EquipmentsendreceivegroupService {

	@Resource(name="commonEntityDao")
	private EntityDao dao;
	
	/**
	 * 新增
	 * */
	public EActionStatus addEquipmentsendreceivegroup(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean) {
		return this.dao.create(equipmentsendreceivegroupBean);
	}
	
	/**
	 * 删除
	 * */
	public EActionStatus delEquipmentsendreceivegroup(EquipmentsendreceivegroupBeanExample beanExample) {
		return this.dao.deleteByCriteria(EquipmentsendreceivegroupBean.class,beanExample);
	}
	
	/**
	 * 更新菜单
	 * */
	public EActionStatus updateEquipmentsendreceivegroup(EquipmentsendreceivegroupBean equipmentsendreceivegroupBean,EquipmentsendreceivegroupBeanExample beanExample) {
		return this.dao.updateByCriteria(equipmentsendreceivegroupBean, beanExample);
	}

	/**
	 * 根据主键查找
	 */
	public EquipmentsendreceivegroupBean findEquipmentsendreceivegroupByPK(EquipmentsendreceivegroupBeanExample beanExample) {
		return this.dao.find(EquipmentsendreceivegroupBean.class, beanExample, 0, 1).get(0);
	}
	
	/**
	 * 分页查找,只查到指定行数的数据。
	 * @param map
	 * @return
	 */
	public FindResult findEquipmentsendreceivegroupByPage(HashMap map){
		int pageIndex = Integer.parseInt(map.get("page").toString());
		int pageSize = Integer.parseInt(map.get("rows").toString());
		map.remove("page");
		map.remove("rows");
		return this.dao.find("", map, pageIndex, pageSize);
	}
	
}
