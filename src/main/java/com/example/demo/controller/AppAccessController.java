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
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.VisitorMessageBean;
import com.example.demo.service.AccessMassageService;
import com.example.demo.service.VisitorMassageService;

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
@RequestMapping("/appAccess")
public class AppAccessController {

	@Autowired
	AccessMassageService accessMassageService;
	
	@Autowired
	VisitorMassageService visitorMassageService;
	

	/**
	 * 
	 * <p>
	 * Title: getAccessMessageApp
	 * </p>
	 * <p>
	 * Description:APP进出管理页面数据展示接口
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getAccessMessageApp", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessMessageApp(AccessMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		result = accessMassageService.getAccessMessageApp(bean);
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: getAccessMessage
	 * </p>
	 * <p>
	 * Description:APP进出管理页面,访客列表接口
	 * </p>
	 * 
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getAccessVisiterApp", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getAccessVisiterApp(VisitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = visitorMassageService.getAccessVisiterAppCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<AccessMessageBean> list = visitorMassageService.getAccessVisiterApp(bean);
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
