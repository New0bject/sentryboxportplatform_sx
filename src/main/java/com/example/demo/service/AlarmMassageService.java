package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AlarmBean;

public interface AlarmMassageService {

	List<AlarmBean> getAlarmMessage(AlarmBean bean);

	AlarmBean getAlarmById(AlarmBean bean);

	int getCount(AlarmBean bean);

}
