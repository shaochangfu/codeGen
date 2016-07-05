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
@Service("equipmentmessageService")
public class EquipmentmessageServiceImpl implements EquipmentmessageService {

	@Resource(name="commonEntityDao")
	private EntityDao dao;
	
	/**
	 * 新增
	 * */
	public EActionStatus addEquipmentmessage(EquipmentmessageBean equipmentmessageBean) {
		return this.dao.create(equipmentmessageBean);
	}
	
	/**
	 * 删除
	 * */
	public EActionStatus delEquipmentmessage(EquipmentmessageBeanExample beanExample) {
		return this.dao.deleteByCriteria(EquipmentmessageBean.class,beanExample);
	}
	
	/**
	 * 更新菜单
	 * */
	public EActionStatus updateEquipmentmessage(EquipmentmessageBean equipmentmessageBean,EquipmentmessageBeanExample beanExample) {
		return this.dao.updateByCriteria(equipmentmessageBean, beanExample);
	}

	/**
	 * 根据主键查找
	 */
	public EquipmentmessageBean findEquipmentmessageByPK(EquipmentmessageBeanExample beanExample) {
		return this.dao.find(EquipmentmessageBean.class, beanExample, 0, 1).get(0);
	}
	
	/**
	 * 分页查找,只查到指定行数的数据。
	 * @param map
	 * @return
	 */
	public FindResult findEquipmentmessageByPage(HashMap map){
		int pageIndex = Integer.parseInt(map.get("page").toString());
		int pageSize = Integer.parseInt(map.get("rows").toString());
		map.remove("page");
		map.remove("rows");
		return this.dao.find("", map, pageIndex, pageSize);
	}
	
}
