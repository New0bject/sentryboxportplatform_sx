package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.AlarmBean;
import com.example.demo.model.MonitorMessageBean;

@Repository
public interface AlarmMassageMapper {

	List<AlarmBean> getAlarmMessage(AlarmBean bean);

	AlarmBean getAlarmById(AlarmBean bean);

	int getCount(AlarmBean bean);


}
