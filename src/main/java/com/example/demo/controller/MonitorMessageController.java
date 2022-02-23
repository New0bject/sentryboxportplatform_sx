package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MonitorMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.service.AccessMassageService;
import com.example.demo.service.MonitorMassageService;

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
@RequestMapping("/monitor")
public class MonitorMessageController {

	@Autowired
	MonitorMassageService monitorMassageService;

	/**
	 * 
	 * <p>
	 * Title: getAccessMessage
	 * </p>
	 * <p>
	 * Description:获取全部进出信息
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getMonitorMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessMessage(MonitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = monitorMassageService.getCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<MonitorMessageBean> list = monitorMassageService.getMonitorMessage(bean);
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
	 * Description:根据ID获取进出信息
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getMonitorById", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessById(MonitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		MonitorMessageBean monitorMessageBean = monitorMassageService.getMonitorById(bean);
		if (monitorMessageBean != null) {
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(monitorMessageBean);
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
	 * Description:新增进出记录接口
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/insertMonitorMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet insertMonitorMessage(@RequestParam(value="data") String data) {
		ResultBeanRet result = new ResultBeanRet();
		result = monitorMassageService.insertMonitorMessage(data);
		return result;
	}
	
	
	@RequestMapping(value = "/aaa", method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<Void> aaa(@RequestParam(value="data") String data) {
//		ResultBeanRet result = new ResultBeanRet();
//		result = monitorMassageService.insertMonitorMessage(data);
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
}
