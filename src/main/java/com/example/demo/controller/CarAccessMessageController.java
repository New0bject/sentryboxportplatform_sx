package com.example.demo.controller;

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
import com.example.demo.model.CarAccessAlarmBean;
import com.example.demo.model.CarAccessBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.service.AccessMassageService;
import com.example.demo.service.CarAccessMassageService;

/**
 * 
 * <p>
 * Title: CarAccessMessageController
 * </p>
 * <p>
 * Description: RESTful接口类
 * </p>
 * 
 * @author Prince
 * @date 2020年6月5日
 */
@RestController
@RequestMapping("/carAccess")
public class CarAccessMessageController {

	@Autowired
	CarAccessMassageService carAccessMassageService;

	
	/**
	 * 
	 * <p>
	 * Title: getAlarmList
	 * </p>
	 * <p>
	 * Description:APP车辆管理异常列表接口
	 * </p>
	 * 
	 * @param RiskAlarmBean
	 * @return
	 */
	@RequestMapping(value = "/getCarAccessAlarmList", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getCarAccessAlarmList(CarAccessAlarmBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = carAccessMassageService.getCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<CarAccessAlarmBean> list = carAccessMassageService.getCarAccessAlarmList(bean);
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
	 * Title: insertCarAccessMessage
	 * </p>
	 * <p>
	 * Description:车辆进出记录插入接口
	 * </p>
	 * 
	 * @param RiskAlarmBean
	 * @return
	 */
	@RequestMapping(value = "/insertCarAccessMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet insertCarAccessMessage(CarAccessBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		result = carAccessMassageService.insertCarAccessMessage(bean);
		return result;
	}
}
