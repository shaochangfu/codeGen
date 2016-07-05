package ${packageName};

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
@Service("${beanName}Service")
public class ${beanNameClass}ServiceImpl implements ${beanNameClass}Service {

	@Resource(name="commonEntityDao")
	private EntityDao dao;
	
	/**
	 * 新增
	 * */
	public EActionStatus add${beanNameClass}(${beanNameClass}Bean ${beanName}Bean) {
		return this.dao.create(${beanName}Bean);
	}
	
	/**
	 * 删除
	 * */
	public EActionStatus del${beanNameClass}(${beanNameClass}BeanExample beanExample) {
		return this.dao.deleteByCriteria(${beanNameClass}Bean.class,beanExample);
	}
	
	/**
	 * 更新菜单
	 * */
	public EActionStatus update${beanNameClass}(${beanNameClass}Bean ${beanName}Bean,${beanNameClass}BeanExample beanExample) {
		return this.dao.updateByCriteria(${beanName}Bean, beanExample);
	}

	/**
	 * 根据主键查找
	 */
	public ${beanNameClass}Bean find${beanNameClass}ByPK(${beanNameClass}BeanExample beanExample) {
		return this.dao.find(${beanNameClass}Bean.class, beanExample, 0, 1).get(0);
	}
	
	/**
	 * 分页查找,只查到指定行数的数据。
	 * @param map
	 * @return
	 */
	public FindResult find${beanNameClass}ByPage(HashMap map){
		int pageIndex = Integer.parseInt(map.get("page").toString());
		int pageSize = Integer.parseInt(map.get("rows").toString());
		map.remove("page");
		map.remove("rows");
		return this.dao.find("", map, pageIndex, pageSize);
	}
	
}
