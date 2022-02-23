package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.AlarmBean;
import com.example.demo.model.CarAccessAlarmBean;
import com.example.demo.model.CarAccessBean;
import com.example.demo.model.ResultBeanRet;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.VisitorAlarmBean;
import com.example.demo.model.VisitorMessageBean;

public interface CarAccessMassageService {

	int getCarAlarmCount(RiskAlarmBean bean);

	CarAccessAlarmBean getCarAccessAlarmById(int id);

	int getCount(CarAccessAlarmBean bean);

	List<CarAccessAlarmBean> getCarAccessAlarmList(CarAccessAlarmBean bean);

	ResultBeanRet insertCarAccessMessage(CarAccessBean bean);



}
