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
import com.example.demo.model.AlarmBean;
import com.example.demo.model.CarAccessAlarmBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.VisitorAlarmBean;
import com.example.demo.model.VisitorMessageBean;
import com.example.demo.service.AccessMassageService;
import com.example.demo.service.CarAccessMassageService;
import com.example.demo.service.RistMassageService;
import com.example.demo.service.VisitorMassageService;

/**
 * 
 * <p>
 * Title: AppRiskController
 * </p>
 * <p>
 * Description: RESTful接口类
 * </p>
 * 
 * @author Prince
 * @date 2020年6月5日
 */
@RestController
@RequestMapping("/appRisk")
public class AppRiskController {

	@Autowired
	AccessMassageService accessMassageService;
	
	@Autowired
	VisitorMassageService visitorMassageService;
	
	@Autowired
	CarAccessMassageService carAccessMassageService;
	
	@Autowired
	RistMassageService ristMassageService;

	/**
	 * 
	 * <p>
	 * Title: getRiskMessageApp
	 * </p>
	 * <p>
	 * Description:APP风险管理数据接口
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getRiskMessageApp", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getRiskMessageApp(RiskAlarmBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		Map<String ,Object> resultMap = new HashMap<String ,Object>();
		int accessAlarm = accessMassageService.getAccessAlarmCount(bean);
		int carAlarm = carAccessMassageService.getCarAlarmCount(bean);
		int visitorAlarm = visitorMassageService.getVisitorAlarmCount(bean);
		resultMap.put("accessAlarm", accessAlarm);
		resultMap.put("carAlarm", carAlarm);
		resultMap.put("visitorAlarm", visitorAlarm);
		result.setCode(200);
		result.setMessage("成功");
		result.setData(resultMap);
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: getAlarmList
	 * </p>
	 * <p>
	 * Description:APP风险管理列表接口
	 * </p>
	 * 
	 * @param RiskAlarmBean
	 * @return
	 */
	@RequestMapping(value = "/getAlarmList", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAlarmList(RiskAlarmBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = ristMassageService.getCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<RiskAlarmBean> list = ristMassageService.getAlarmList(bean);
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
	 * Title: getmessageByIdApp
	 * </p>
	 * <p>
	 * Description:APP风险管理详情接口
	 * </p>
	 * 
	 * @param RiskAlarmBean
	 * @return
	 */
	@RequestMapping(value = "/getmessageByIdApp", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getmessageByIdApp(RiskAlarmBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		if("访客异常".equals(bean.getAlarm_type())){
			VisitorAlarmBean resultBean = visitorMassageService.getVisitorAlarmById(bean.getId());
			if (resultBean != null) {
				result.setCode(200);
				result.setMessage("查询成功");
				result.setData(resultBean);
			} else {
				result.setCode(900);
				result.setMessage("暂无记录");
			}
		}else if("车辆异常".equals(bean.getAlarm_type())){
			CarAccessAlarmBean resultBean = carAccessMassageService.getCarAccessAlarmById(bean.getId());
			if (resultBean != null) {
				result.setCode(200);
				result.setMessage("查询成功");
				result.setData(resultBean);
			} else {
				result.setCode(900);
				result.setMessage("暂无记录");
			}
		}else if("进出异常".equals(bean.getAlarm_type())){
			AlarmBean resultBean = accessMassageService.getAccessAlarmById(bean.getId());
			if (resultBean != null) {
				result.setCode(200);
				result.setMessage("查询成功");
				result.setData(resultBean);
			} else {
				result.setCode(900);
				result.setMessage("暂无记录");
			}
		}
		
		return result;
	}
}
