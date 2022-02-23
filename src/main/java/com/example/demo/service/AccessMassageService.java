package com.example.demo.service;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.AlarmBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.RiskAlarmBean;
import java.util.List;

/* loaded from: AccessMassageService.class */
public interface AccessMassageService {
	List<AccessMessageBean> getAccessMessage(AccessMessageBean accessMessageBean);
	List<AccessMessageBean> getAccessMessageSx(AccessMessageBean accessMessageBean);
	AccessMessageBean getAccessById(AccessMessageBean accessMessageBean);

	ResultBeanRet handleMessage(AccessMessageBean accessMessageBean);

	ResultBeanRet getAccessByPerson(AccessMessageBean accessMessageBean);

	ResultBeanRet getAccessByApparatus(AccessMessageBean accessMessageBean);

	int getCount(AccessMessageBean accessMessageBean);
	int getCountSx(AccessMessageBean accessMessageBean);

	ResultBeanRet insertAccessMessage(String str);

	ResultBeanRet getMessageCount(AccessMessageBean accessMessageBean);

	List<AccessMessageBean> getAccessMessageMain(AccessMessageBean accessMessageBean);

	ResultBeanRet getAccessMessageApp(AccessMessageBean accessMessageBean);

	int getAccessAlarmCount(RiskAlarmBean riskAlarmBean);

	AlarmBean getAccessAlarmById(int i);

	List<String> getGroupIds(String str);
}