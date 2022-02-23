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
import com.example.demo.model.VisitorAlarmBean;
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
@RequestMapping("/appVisiter")
public class AppVisiterController {

	@Autowired
	AccessMassageService accessMassageService;
	
	@Autowired
	VisitorMassageService visitorMassageService;

	/**
	 * 
	 * <p>
	 * Title: getVisitorMessage
	 * </p>
	 * <p>
	 * Description:APP访客管理,访客列表
	 * </p>
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getVisitorMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getVisitorMessage(VisitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = visitorMassageService.getCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<VisitorMessageBean> list  = visitorMassageService.getVisitorMessage(bean);
		for(VisitorMessageBean visitorMessageBean : list){
			int visitCount = visitorMassageService.getVisitCount(visitorMessageBean);
			if(visitCount > 5){
				String visitor_type = "";
				visitor_type = !"正常访客".equals(visitorMessageBean.getVisitor_type())?visitorMessageBean.getVisitor_type()+"+经常拜访":"经常拜访";
				visitorMessageBean.setVisitor_type(visitor_type);
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		if(list != null && list.size() > 0){
			map.put("totalMessage", count);
			map.put("totalPage", bean.getTotalPage());
			map.put("data", list);
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(map);
		}else{
			result.setCode(900);
			result.setMessage("暂无记录");
		}
		return result;
	}

	/**
	 *
	 * <p>
	 * Title: getVisitorMessage
	 * </p>
	 * <p>
	 * Description:APP访客管理,访客列表
	 * </p>
	 *
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getVisitorMessageSx", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getVisitorMessageSx(VisitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = visitorMassageService.getCountSx(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<VisitorMessageBean> list  = visitorMassageService.getVisitorMessageSx(bean);
		for(VisitorMessageBean visitorMessageBean : list){
			int visitCount = visitorMassageService.getVisitCount(visitorMessageBean);
			if(visitCount > 5){
				String visitor_type = "";
				visitor_type = !"正常访客".equals(visitorMessageBean.getVisitor_type())?visitorMessageBean.getVisitor_type()+"+经常拜访":"经常拜访";
				visitorMessageBean.setVisitor_type(visitor_type);
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		if(list != null && list.size() > 0){
			map.put("totalMessage", count);
			map.put("totalPage", bean.getTotalPage());
			map.put("data", list);
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(map);
		}else{
			result.setCode(900);
			result.setMessage("暂无记录");
		}
		return result;
	}

	/**
	 * 
	 * <p>
	 * Title: getVisitorById
	 * </p>
	 * <p>
	 * Description:APP访客管理,根据ID获取访客登记信息
	 * </p>
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getVisitorById", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getVisitorById(VisitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		VisitorMessageBean visitorMessageBean  = visitorMassageService.getVisitorById(bean.getId());
		if(visitorMessageBean != null){
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(visitorMessageBean);
		}else{
			result.setCode(900);
			result.setMessage("暂无记录");
		}
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: getUnusualVisitor
	 * </p>
	 * <p>
	 * Description:APP访客管理,异常访客列表
	 * </p>
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getUnusualVisitor", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getUnusualVisitor(VisitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		int count = visitorMassageService.getUnusualVisitorCount(bean);
		if ((bean.getTotalPage() - 1) * bean.getLineCount() >= count) {
			result.setCode(-1);
			result.setMessage("没有更多");
			return result;
		}
		bean.setPage((bean.getTotalPage() - 1) * bean.getLineCount());
		List<VisitorAlarmBean> list  = visitorMassageService.getUnusualVisitor(bean);
		Map<String,Object> map = new HashMap<String,Object>();
		if(list != null && list.size() > 0){
			map.put("totalMessage", count);
			map.put("totalPage", bean.getTotalPage());
			map.put("data", list);
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(map);
		}else{
			result.setCode(900);
			result.setMessage("暂无记录");
		}
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: getAccessMessageApp
	 * </p>
	 * <p>
	 * Description:APP访客管理页面数据展示接口
	 * </p>
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getCountMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getCountMessage(VisitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		result = visitorMassageService.getCountMessage(bean);
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: getUnusualByMonth
	 * </p>
	 * <p>
	 * Description:APP访客管理日历异常状态接口
	 * </p>
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getUnusualByMonth", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getUnusualByMonth(VisitorMessageBean bean) {
		ResultBeanRet result = new ResultBeanRet();
		result = visitorMassageService.getUnusualByMonth(bean);
		return result;
	}
}
