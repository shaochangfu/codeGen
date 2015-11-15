package ${packageName};

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author scf
 *
 */
@Service
public class ${beanNameClass}ServiceImpl implements ${beanNameClass}Service {

	@Autowired
	${beanNameClass}Dao ${beanName}Dao;
	
	public ${beanNameClass}Bean insert(${beanNameClass}Bean ${beanName}Bean) {
		return ${beanName}Dao.insert(${beanName}Bean);
	}
	public int update(${beanNameClass}Bean ${beanName}Bean) {
		return ${beanName}Dao.update(${beanName}Bean);
	}
	public int delete(int id) {
		return ${beanName}Dao.delete(id);
	}
	public List<${beanNameClass}Bean> findByPrimaryKey(int id) {
		return ${beanName}Dao.findByPrimaryKey(id);
	}
	public List<${beanNameClass}Bean> findAllByPage(${beanNameClass}Bean ${beanName}Bean, int start, int detla) {
		return ${beanName}Dao.findAllByPage(${beanName}Bean, start, detla);
	}
	public int findAllCount(${beanNameClass}Bean ${beanName}Bean) {
		return ${beanName}Dao.findAllCount(${beanName}Bean);
	}
}
