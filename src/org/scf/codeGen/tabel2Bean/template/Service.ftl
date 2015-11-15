package ${packageName};

import java.util.List;

/**
 * 
 * @author scf
 *
 */
public interface ${beanNameClass}Service {
	/**
	 * 新增记录
	 * @param ${beanName}
	 * @return
	 */
	public ${beanNameClass}Bean insert(${beanNameClass}Bean ${beanName}Bean);
	/**
	 * 更新
	 * @param ${beanName}Bean
	 * @return
	 */
	public int update(${beanNameClass}Bean ${beanName}Bean);
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public int delete(int id);
	/**
	 * 根据主键查找
	 * @param id
	 * @return
	 */
	public List<${beanNameClass}Bean> findByPrimaryKey(int id);
	/**
	 * 分页查询
	 * @param ${beanName}Bean
	 * @param start
	 * @param detla
	 * @return
	 */
	public List<${beanNameClass}Bean> findAllByPage(${beanNameClass}Bean ${beanName}Bean,int start,int detla);
	
	/**
	 * 记录总条数
	 * @param ${beanName}Bean
	 * @return
	 */
	public int findAllCount(${beanNameClass}Bean ${beanName}Bean);
	
}
