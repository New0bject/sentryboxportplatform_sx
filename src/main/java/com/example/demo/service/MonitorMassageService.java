package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.MonitorMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.VisitorMessageBean;

public interface MonitorMassageService {

	List<MonitorMessageBean> getMonitorMessage(MonitorMessageBean bean);

	MonitorMessageBean getMonitorById(MonitorMessageBean bean);

	ResultBeanRet insertMonitorMessage(String data);

	int getCount(MonitorMessageBean bean);

}
