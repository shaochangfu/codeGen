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
@Service("equipmentroomService")
public class EquipmentroomServiceImpl implements EquipmentroomService {

	@Resource(name="commonEntityDao")
	private EntityDao dao;
	
	/**
	 * 新增
	 * */
	public EActionStatus addEquipmentroom(EquipmentroomBean equipmentroomBean) {
		return this.dao.create(equipmentroomBean);
	}
	
	/**
	 * 删除
	 * */
	public EActionStatus delEquipmentroom(EquipmentroomBeanExample beanExample) {
		return this.dao.deleteByCriteria(EquipmentroomBean.class,beanExample);
	}
	
	/**
	 * 更新菜单
	 * */
	public EActionStatus updateEquipmentroom(EquipmentroomBean equipmentroomBean,EquipmentroomBeanExample beanExample) {
		return this.dao.updateByCriteria(equipmentroomBean, beanExample);
	}

	/**
	 * 根据主键查找
	 */
	public EquipmentroomBean findEquipmentroomByPK(EquipmentroomBeanExample beanExample) {
		return this.dao.find(EquipmentroomBean.class, beanExample, 0, 1).get(0);
	}
	
	/**
	 * 分页查找,只查到指定行数的数据。
	 * @param map
	 * @return
	 */
	public FindResult findEquipmentroomByPage(HashMap map){
		int pageIndex = Integer.parseInt(map.get("page").toString());
		int pageSize = Integer.parseInt(map.get("rows").toString());
		map.remove("page");
		map.remove("rows");
		return this.dao.find("", map, pageIndex, pageSize);
	}
	
}
