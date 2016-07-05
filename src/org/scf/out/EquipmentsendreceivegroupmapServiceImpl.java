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
@Service("equipmentsendreceivegroupmapService")
public class EquipmentsendreceivegroupmapServiceImpl implements EquipmentsendreceivegroupmapService {

	@Resource(name="commonEntityDao")
	private EntityDao dao;
	
	/**
	 * 新增
	 * */
	public EActionStatus addEquipmentsendreceivegroupmap(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean) {
		return this.dao.create(equipmentsendreceivegroupmapBean);
	}
	
	/**
	 * 删除
	 * */
	public EActionStatus delEquipmentsendreceivegroupmap(EquipmentsendreceivegroupmapBeanExample beanExample) {
		return this.dao.deleteByCriteria(EquipmentsendreceivegroupmapBean.class,beanExample);
	}
	
	/**
	 * 更新菜单
	 * */
	public EActionStatus updateEquipmentsendreceivegroupmap(EquipmentsendreceivegroupmapBean equipmentsendreceivegroupmapBean,EquipmentsendreceivegroupmapBeanExample beanExample) {
		return this.dao.updateByCriteria(equipmentsendreceivegroupmapBean, beanExample);
	}

	/**
	 * 根据主键查找
	 */
	public EquipmentsendreceivegroupmapBean findEquipmentsendreceivegroupmapByPK(EquipmentsendreceivegroupmapBeanExample beanExample) {
		return this.dao.find(EquipmentsendreceivegroupmapBean.class, beanExample, 0, 1).get(0);
	}
	
	/**
	 * 分页查找,只查到指定行数的数据。
	 * @param map
	 * @return
	 */
	public FindResult findEquipmentsendreceivegroupmapByPage(HashMap map){
		int pageIndex = Integer.parseInt(map.get("page").toString());
		int pageSize = Integer.parseInt(map.get("rows").toString());
		map.remove("page");
		map.remove("rows");
		return this.dao.find("", map, pageIndex, pageSize);
	}
	
}
