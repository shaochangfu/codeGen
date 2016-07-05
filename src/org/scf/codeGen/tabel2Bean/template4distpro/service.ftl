package ${packageName};

import org.youme.dbcacherouter.EActionStatus;
import org.youme.dbcacherouter.mybatis.FindResult;
import java.util.HashMap;

/**
**/
public interface ${beanNameClass}Service{
	/**
	 * */
	public EActionStatus add${beanNameClass}(${beanNameClass}Bean ${beanName}Bean); 
	/**
	 * */
	public EActionStatus del${beanNameClass}(${beanNameClass}BeanExample beanExample);
	/**
	 * */
	public EActionStatus update${beanNameClass}(${beanNameClass}Bean ${beanName}Bean,${beanNameClass}BeanExample beanExample);
	
	/**
	 */
	public ${beanNameClass}Bean find${beanNameClass}ByPK(${beanNameClass}BeanExample beanExample);
	/**
	 */
	public FindResult find${beanNameClass}ByPage(HashMap map);
}