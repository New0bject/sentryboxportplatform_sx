package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.VisitorMessageBean;
import com.example.demo.service.VisitorMassageService;

/**
 * 
 * <p>
 * Title: VisitorMessageController
 * </p>
 * <p>
 * Description: RESTful接口类
 * </p>
 * 
 * @author Prince
 * @date 2019年10月22日
 */
@RestController
@RequestMapping("/visitor")
public class VisitorMessageController {

	@Autowired
	VisitorMassageService visitorMassageService;

	/**
	 * 
	 * <p>
	 * Title: getVisitorMessage
	 * </p>
	 * <p>
	 * Description:访客登记全部信息
	 * </p>
	 * 
	 * @param interactiveBean
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
		Map<String,Object> map = new HashMap<String,Object>();
		if(list != null && list.size() > 0){
			map.put("totalMessage", count);
			map.put("totalPage", bean.getTotalPage());
			map.put("data", list);
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(map);
		}else{
			result.setCode(-1);
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
	 * Description:访客登记全部信息
	 * </p>
	 *
	 * @param interactiveBean
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
		Map<String,Object> map = new HashMap<String,Object>();
		if(list != null && list.size() > 0){
			map.put("totalMessage", count);
			map.put("totalPage", bean.getTotalPage());
			map.put("data", list);
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(map);
		}else{
			result.setCode(-1);
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
	 * Description:根据ID获取访客登记信息
	 * </p>
	 *
	 * @param interactiveBean
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
			result.setCode(-1);
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
	 * Description:新增访客登记信息记录
	 * </p>
	 *
	 * @param visitorMessageBean
	 * @return
	 */
	@RequestMapping(value = "/insertVisitorMessage", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet insertVisitorMessage(VisitorMessageBean visitorMessageBean) {
		ResultBeanRet result = new ResultBeanRet();
		result  = visitorMassageService.insertVisitorMessage(visitorMessageBean);
		return result;
	}

	/**
	 *
	 * <p>
	 * Title: getdepart
	 * </p>
	 * <p>
	 * Description:获取部门记录
	 * </p>
	 *
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getdepart", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet getdepart(String group_id) {
		ResultBeanRet result = new ResultBeanRet();
		String parentId = group_id;
		List<Map<String,Object>> deptList  = visitorMassageService.getdepart(parentId);
		if(deptList != null && deptList.size() > 0){
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(deptList);
		}else{
			result.setCode(-1);
			result.setMessage("暂无数据");
		}
		return result;
	}

	/**
	 *
	 * <p>
	 * Title: getUserByDepart
	 * </p>
	 * <p>
	 * Description:根据部门获取人员名称
	 * </p>
	 *
	 * @param interactiveBean
	 * @return
	 */
	@RequestMapping(value = "/getUserByDepart", method = RequestMethod.GET)
	@CrossOrigin
	public ResultBeanRet getUserByDepart(@RequestParam(name = "dept_id") String dept_id) {
		ResultBeanRet result = new ResultBeanRet();
		List<Map<String,Object>> userList  = visitorMassageService.getUserByDepart(dept_id);
		if(userList != null && userList.size() > 0){
			result.setCode(200);
			result.setMessage("查询成功");
			result.setData(userList);
		}else{
			result.setCode(-1);
			result.setMessage("暂无数据");
		}
		return result;
	}
	
	/**
	 * 
	 * <p>
	 * Title: uploadImg
	 * </p>
	 * <p>
	 * Description:上传图片接口
	 * </p>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet uploadImg(HttpServletRequest request) {
		ResultBeanRet result = new ResultBeanRet();
		String picPath  = visitorMassageService.uploadImg(request);
		if(!StringUtils.isEmpty(picPath)){
			result.setCode(200);
			result.setMessage("上传成功");
			result.setData(picPath);
		}else{
			result.setCode(500);
			result.setMessage("查询失败");
		}
		return result;
	}
	
	/**
	 * 浦东支队更新访客记录状态(受访人是否确认)
	 * <p>Title: updateVisitStatus</p>  
	 * <p>Description: </p>  
	 * @param visitorMessageBean
	 * @return
	 */
	@RequestMapping(value = "/updateVisitStatus", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet updateVisitStatus(VisitorMessageBean visitorMessageBean) {
		ResultBeanRet result = new ResultBeanRet();
		result  = visitorMassageService.updateVisitStatus(visitorMessageBean);
		return result;
	}
	
	/**
	 * 离队时间更新
	 * <p>Title: updateVisitStatus</p>  
	 * <p>Description: </p>  
	 * @param visitorMessageBean
	 * @return
	 */
	@RequestMapping(value = "/updateLeaveTime", method = RequestMethod.POST)
	@CrossOrigin
	public ResultBeanRet updateLeaveTime(VisitorMessageBean visitorMessageBean) {
		ResultBeanRet result = new ResultBeanRet();
		result  = visitorMassageService.updateLeaveTime(visitorMessageBean);
		return result;
	}
}
