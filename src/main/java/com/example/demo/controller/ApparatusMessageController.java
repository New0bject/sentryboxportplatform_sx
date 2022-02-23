package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApparatusCategoryBean;
import com.example.demo.model.ApparatusMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.service.ApparatusMassageService;

/**
 * 
 * <p>
 * Title: ApparatusMessageController
 * </p>
 * <p>
 * Description: RESTful接口类
 * </p>
 * 
 * @author Prince
 * @date 2019年10月22日
 */
@RestController
@RequestMapping("/apparatus")
public class ApparatusMessageController {

	@Autowired
	ApparatusMassageService apparatusMassageService;

	/**
	 * 
	 * <p>
	 * Title: getApparatusMessage
	 * </p>
	 * <p>
	 * Description:获取设备信息
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getApparatusMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getApparatusMessage(ApparatusCategoryBean apparatusCategoryBean) {
		ResultBeanRet result = new ResultBeanRet();
		
		List<ApparatusCategoryBean> Categorylist  = apparatusMassageService.getApparatusCategory();
		List<Map<String ,Object>> resultList = new ArrayList<Map<String ,Object>>();
		for(ApparatusCategoryBean bean : Categorylist){
			bean.setAttribution_dept(apparatusCategoryBean.getAttribution_dept());
			List<ApparatusMessageBean> list  = apparatusMassageService.getApparatusMessage(bean);
			Map<String ,Object> resultMap = new HashMap<String ,Object>();
			resultMap.put("category_name", bean.getApparatus_category_name());
			resultMap.put("apparatus", list);
			resultList.add(resultMap);
		}
		result.setCode(200);
		result.setMessage("查询成功");
		result.setData(resultList);
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: getApparatusByGroup
	 * </p>
	 * <p>
	 * Description:根据部门获取设备信息
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getApparatusByGroup", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getApparatusByGroup(ApparatusCategoryBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		
		List<ApparatusCategoryBean> Categorylist  = apparatusMassageService.getApparatusByGroup(bean);
		
		if(Categorylist != null && Categorylist.size() > 0){
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(Categorylist);
		}else{
			result.setCode(900);
			result.setMessage("暂无数据");
		}
	
		return result;
	}
}
