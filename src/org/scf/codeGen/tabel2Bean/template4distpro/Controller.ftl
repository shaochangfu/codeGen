package ${packageName};

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import org.youme.common.date.DateConverter;

/**
 *	
 * @author scf
 *
 */
@Controller
@RequestMapping(value = "/${beanName}")
public class ${beanNameClass}Controller {
	private Logger log = LoggerFactory.getLogger(${beanNameClass}Controller.class);
	
	@Autowired
	${beanNameClass}Service ${beanName}Service;
	/**
		根据主键查找
	*/
	@ResponseBody
	@RequestMapping(value="/find${beanNameClass}ByPK",method=RequestMethod.GET)
	@SystemControllerLog(description = "根据主键查询数据")
	public ${beanNameClass}Bean find${beanNameClass}ByPK(String pk){
		${beanNameClass}BeanExample ${beanName}e = new ${beanNameClass}BeanExample();
		${beanName}e.createCriteria().andIdEqualTo(pk);
		${beanNameClass}Bean ${beanName} = ${beanName}Service.find${beanNameClass}ByPK(${beanName}e);
		return ${beanName};
	}
	
	/**
		新增
	*/
	@ResponseBody
	@RequestMapping(value = "/add${beanNameClass}")
	@SystemControllerLog(description = "新增")
	public ${beanNameClass}Bean add${beanNameClass}(String jsonStr,HttpServletRequest request,HttpServletResponse response){
		${beanNameClass}Bean ${beanName} = new ${beanNameClass}Bean();
		try {
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtils.populate(${beanName},request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		${beanName}.setId(GeneratePK.UUID());
		${beanName}Service.add${beanNameClass}(${beanName});
		return ${beanName};
	}
	
	/**
		删除
	*/
	@ResponseBody
	@RequestMapping(value="/del${beanNameClass}")
	@SystemControllerLog(description = "删除")
	public BooleanDto del${beanNameClass}(String id){
		BooleanDto result = new BooleanDto();
		${beanNameClass}BeanExample ${beanName}e = new ${beanNameClass}BeanExample();
		${beanName}e.createCriteria().andIdEqualTo(id);
		EActionStatus e = ${beanName}Service.del${beanNameClass}(${beanName}e);
		if(e==EActionStatus.Fail){
			result.setMsg("删除失败!");
			result.setSuccess(false);
		}else{
			result.setSuccess(true);
			result.setMsg("删除成功!");
		}
		return result;
	}
	
	/**
		更新
	*/
	@ResponseBody
	@RequestMapping(value="/update${beanNameClass}")
	public ${beanNameClass}Bean update${beanNameClass}(String id,HttpServletRequest request,HttpServletResponse response){
		RequestContext requestContext = new RequestContext(request);
		BooleanDto dto = new BooleanDto();
		${beanNameClass}Bean ${beanName} = new ${beanNameClass}Bean();
		try {
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtils.populate(${beanName},request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		${beanNameClass}BeanExample ${beanName}e = new ${beanNameClass}BeanExample();
		${beanName}e.createCriteria().andIdEqualTo(id);
		${beanName}Service.update${beanNameClass}(${beanName}, ${beanName}e);
		return ${beanName};
	}
	
	/**
		分页查询 
	*/
	@ResponseBody
	@RequestMapping(value="/find${beanNameClass}ByPage",method=RequestMethod.POST)
	@SystemControllerLog(description = "根据条件分页查询 ")
	public Map<String, Object>  find${beanNameClass}(HttpServletRequest request,int page,int rows){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("page", page-1);
		map.put("rows", rows);
		// 增加查询条件
		FindResult f = ${beanName}Service.find${beanNameClass}ByPage(map);
		List<?> list = f.getPageData();
		Map<String,Object> mapResult = new HashMap<String, Object>();
		mapResult.put("total", f.getRowCount() );
		mapResult.put("rows", list);
		return mapResult;
	}
}
