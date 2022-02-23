package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.VisitorMessageBean;

public interface RistMassageService {

	int getCount(RiskAlarmBean bean);

	List<RiskAlarmBean> getAlarmList(RiskAlarmBean bean);

}
