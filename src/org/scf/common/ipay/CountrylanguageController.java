package org.scf.common.ipay.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping(value = "/countrylanguage")
public class CountrylanguageController {
	private Logger log = LoggerFactory.getLogger(CountrylanguageController.class);
	
	@Autowired
	CountrylanguageService countrylanguageService;
	/**
	 * 查询对账失败记录,返回json
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "countrylanguageSearch", method = RequestMethod.POST)
	public Map<String,Object> checkSearch(Model model,HttpServletRequest request,HttpServletResponse response) {
		
		// 分页查询参数
		CountrylanguageBean countrylanguageBean = new CountrylanguageBean();
		try {
			BeanUtils.populate(countrylanguageBean,request.getParameterMap());
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
			List list = countrylanguageService.findAllByPage(countrylanguageBean, start, detla);
			int total = countrylanguageService.findAllCount(countrylanguageBean);
			Map<String,Object> map = new HashMap();
			map.put("total", total);
			map.put("rows", list);
			return map;
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
		CountrylanguageBean countrylanguageBean = new CountrylanguageBean();
		try {
			BeanUtils.populate(countrylanguageBean,request.getParameterMap());
		} catch (IllegalAccessException e) {
			bd.setSuccess(false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			bd.setSuccess(false);
			e.printStackTrace();
		} 
		log.debug("请求参数：countrylanguageBean="+countrylanguageBean.toString());
		countrylanguageService.insert(countrylanguageBean);
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
		CountrylanguageBean countrylanguageBean = new CountrylanguageBean();
		try {
			BeanUtils.populate(countrylanguageBean,request.getParameterMap());
		} catch (IllegalAccessException e) {
			bd.setSuccess(false);
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			bd.setSuccess(false);
			e.printStackTrace();
		} 
		log.debug("请求参数：countrylanguageBean="+countrylanguageBean.toString());
		countrylanguageService.update(countrylanguageBean);
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
		countrylanguageService.delete(idi);
		return bd;
	}
	
	/**
	 * 请求入口
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "countrylanguage", method = RequestMethod.GET)
	public String getAddressList(Model model) {
		return "admin/countrylanguage";
	}
}
