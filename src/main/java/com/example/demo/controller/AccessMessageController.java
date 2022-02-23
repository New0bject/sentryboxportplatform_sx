package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.service.AccessMassageService;

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
@Slf4j
@RequestMapping("/access")
public class AccessMessageController {

	@Autowired
	AccessMassageService accessMassageService;

	/**
	 * 
	 * <p>
	 * Title: getAccessMessage
	 * </p>
	 * <p>
	 * Description:获取全部进出信息
	 * </p>
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getAccessMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessMessage(AccessMessageBean bean) {

		ResultBeanRet result = new ResultBeanRet();
		int count = accessMassageService.getCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<AccessMessageBean> list = accessMassageService.getAccessMessage(bean);
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
	 * Title: getAccessMessage
	 * </p>
	 * <p>
	 * Description:获取全部进出信息
	 * </p>
	 *
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getAccessMessageSx", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessMessageSx(AccessMessageBean bean) {
		log.info("========================getAccessMessageSx=============================="+bean);
		ResultBeanRet result = new ResultBeanRet();
		int count = accessMassageService.getCountSx(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<AccessMessageBean> list = accessMassageService.getAccessMessageSx(bean);
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
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getAccessById", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessById(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		AccessMessageBean accessMessageBean = accessMassageService
				.getAccessById(bean);
		if (accessMessageBean != null) {
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(accessMessageBean);
		} else {
			result.setCode(900);
			result.setMessage("暂无记录");
		}
		return result;
	}

	/**
	 * 
	 * <p>
	 * Title: insertVisitorMessage
	 * </p>
	 * <p>
	 * Description:处置接口
	 * </p>
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/handleMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet handleMessage(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		result = accessMassageService.handleMessage(bean);
		return result;
	}

	/**
	 * 
	 * <p>
	 * Title: getAccessByPerson
	 * </p>
	 * <p>
	 * Description:根据人员ID获取交互弹窗右侧人员信息数据及出入记录
	 * </p>
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getAccessByPerson", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessByPerson(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		result = accessMassageService.getAccessByPerson(bean);
		return result;
	}

	/**
	 * 
	 * <p>
	 * Title: getAccessByApparatus
	 * </p>
	 * <p>
	 * Description:根据设备信息查询进出记录
	 * </p>
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getAccessByApparatus", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessByApparatus(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		result = accessMassageService.getAccessByApparatus(bean);
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
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/insertAccessMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet insertAccessMessage(@RequestParam(value="data") String data) {
		ResultBeanRet result = new ResultBeanRet();
		result = accessMassageService.insertAccessMessage(data);
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: insertAccessMessage
	 * </p>
	 * <p>
	 * Description:首页数据显示接口
	 * </p>
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getMessageCount", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getMessageCount(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		result = accessMassageService.getMessageCount(bean);
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: getAccessMessage
	 * </p>
	 * <p>
	 * Description:主页出入管理列表信息
	 * </p>
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getAccessMessageMain", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessMessageMain(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = accessMassageService.getCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<AccessMessageBean> list = accessMassageService.getAccessMessageMain(bean);
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
	
}
