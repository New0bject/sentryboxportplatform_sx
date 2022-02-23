package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.ApparatusCategoryBean;
import com.example.demo.model.ApparatusMessageBean;
import com.example.demo.model.InspectMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.service.ApparatusMassageService;
import com.example.demo.service.InspectMassageService;

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
@RequestMapping("/inspect")
public class InspectMessageController {

	@Autowired
	InspectMassageService inspectMassageService;

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
	@RequestMapping(value = "/getInspectMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getInspectMessage(InspectMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = inspectMassageService.getCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<InspectMessageBean> list = inspectMassageService.getInspectMessage(bean);
		Map<String,Object> map = new HashMap<String,Object>();
		if (list != null && list.size() > 0) {
			map.put("totalMessage", count);
			map.put("totalPage", bean.getTotalPage());
			map.put("data", list);
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(map);
		} else {
			result.setCode(900);
			result.setMessage("暂无记录");
		}
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: insertAccessMessage
	 * </p>
	 * <p>
	 * Description:更新
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/updateInspectMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet updateInspectMessage(InspectMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		result = inspectMassageService.updateInspectMessage(bean);
		return result;
	}
}
