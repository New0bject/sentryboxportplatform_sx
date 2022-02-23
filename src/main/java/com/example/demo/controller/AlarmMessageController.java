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

import com.example.demo.model.AlarmBean;
import com.example.demo.model.MonitorMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.service.AccessMassageService;
import com.example.demo.service.AlarmMassageService;

/**
 * 
 * <p>
 * Title: AccessMessageController
 * </p>
 * <p>
 * Description: RESTful接口类
 * </p>
 * 
 * @author Prince
 * @date 2020年6月5日
 */
@RestController
@RequestMapping("/alarm")
public class AlarmMessageController {

	@Autowired
	AlarmMassageService alarmMassageService;

	/**
	 * 
	 * <p>
	 * Title: getAccessMessage
	 * </p>
	 * <p>
	 * Description:获取全部报警信息
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getAlarmMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAlarmMessage(AlarmBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = alarmMassageService.getCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<AlarmBean> list = alarmMassageService.getAlarmMessage(bean);
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
	 * Title: getAccessById
	 * </p>
	 * <p>
	 * Description:根据ID获取报警信息
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getAlarmById", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAlarmById(AlarmBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		AlarmBean alarmBean = alarmMassageService.getAlarmById(bean);
		if (alarmBean != null) {
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(alarmBean);
		} else {
			result.setCode(900);
			result.setMessage("暂无记录");
		}
		return result;
	}

}
