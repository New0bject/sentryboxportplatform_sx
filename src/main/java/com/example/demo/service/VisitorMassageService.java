package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.VisitorAlarmBean;
import com.example.demo.model.VisitorMessageBean;

public interface VisitorMassageService {

	List<VisitorMessageBean> getVisitorMessage(VisitorMessageBean bean);
	List<VisitorMessageBean> getVisitorMessageSx(VisitorMessageBean bean);

	ResultBeanRet insertVisitorMessage(VisitorMessageBean visitorMessageBean);

	List<Map<String, Object>> getdepart(String parentId);

	List<Map<String, Object>> getUserByDepart(String dept_id);

	String uploadImg(HttpServletRequest request);

	VisitorMessageBean getVisitorById(Integer id);

	int getCount(VisitorMessageBean bean);
	int getCountSx(VisitorMessageBean bean);

	int getAccessVisiterAppCount(VisitorMessageBean bean);

	List<AccessMessageBean> getAccessVisiterApp(VisitorMessageBean bean);

	List<VisitorAlarmBean> getUnusualVisitor(VisitorMessageBean bean);

	int getUnusualVisitorCount(VisitorMessageBean bean);

	int getVisitCount(VisitorMessageBean visitorMessageBean);

	ResultBeanRet getCountMessage(VisitorMessageBean bean);

	int getVisitorAlarmCount(RiskAlarmBean bean);

	VisitorAlarmBean getVisitorAlarmById(int id);

	ResultBeanRet getUnusualByMonth(VisitorMessageBean bean);

	ResultBeanRet updateVisitStatus(VisitorMessageBean visitorMessageBean);

	ResultBeanRet updateLeaveTime(VisitorMessageBean visitorMessageBean);

	

}
