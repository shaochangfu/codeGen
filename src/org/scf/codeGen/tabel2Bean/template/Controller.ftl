package ${packageName};

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.webutils.admin.BooleanDto;

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
	 * 查询对账失败记录,返回json
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "${beanName}Search", method = RequestMethod.POST)
	public List<String> checkSearch(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		// 分页查询参数
		${beanNameClass}Bean ${beanName}Bean = new ${beanNameClass}Bean();
		try {
			BeanUtils.populate(${beanName}Bean,request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		// 查询请求
		try {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			int detla = Integer.parseInt(rows);
			int start = (Integer.parseInt(page)-1)*detla;
			List list = ${beanName}Service.findAllByPage(${beanName}Bean, start, detla);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 新增记录
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "saveRecords", method = RequestMethod.POST)
	public BooleanDto saveRecords(Model model,HttpServletRequest request, HttpServletResponse response){
		BooleanDto bd = new BooleanDto();
		bd.setSuccess(true);
		${beanNameClass}Bean ${beanName}Bean = new ${beanNameClass}Bean();
		try {
			BeanUtils.populate(${beanName}Bean,request.getParameterMap());
		} catch (IllegalAccessException e) {
			bd.setSuccess(false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			bd.setSuccess(false);
			e.printStackTrace();
		} 
		log.debug("请求参数：${beanName}Bean="+${beanName}Bean.toString());
		${beanName}Service.insert(${beanName}Bean);
		return bd;
	}
	/**
	 * 更新记录
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateRecords", method = RequestMethod.POST)
	public BooleanDto updateRecords(Model model,HttpServletRequest request, HttpServletResponse response){
		BooleanDto bd = new BooleanDto();
		bd.setSuccess(true);
		${beanNameClass}Bean ${beanName}Bean = new ${beanNameClass}Bean();
		try {
			BeanUtils.populate(${beanName}Bean,request.getParameterMap());
		} catch (IllegalAccessException e) {
			bd.setSuccess(false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			bd.setSuccess(false);
			e.printStackTrace();
		} 
		log.debug("请求参数：${beanName}Bean="+${beanName}Bean.toString());
		${beanName}Service.update(${beanName}Bean);
		return bd;
	}
	
	/**
	 * 删除记录
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "removeRecords", method = RequestMethod.POST)
	public BooleanDto removeRecords(Model model,HttpServletRequest request, HttpServletResponse response){
		
		BooleanDto bd = new BooleanDto();
		bd.setSuccess(true);
		String id = request.getParameter("id");
		int idi = Integer.getInteger(id);
		log.debug("请求参数：id="+id);
		${beanName}Service.delete(idi);
		return bd;
	}
	
	/**
	 * 请求入口
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "${beanName}", method = RequestMethod.GET)
	public String getAddressList(Model model) {
		return "admin/${beanName}";
	}
}
