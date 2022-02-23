package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.AlarmBean;
import com.example.demo.model.CarAccessAlarmBean;
import com.example.demo.model.CarAccessBean;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.VisitorMessageBean;

@Repository
public interface CarAccessMassageMapper {

	int getCarAlarmCount(RiskAlarmBean bean);

	CarAccessAlarmBean getCarAccessAlarmById(int id);

	List<CarAccessAlarmBean> getCarAccessAlarmList(CarAccessAlarmBean bean);

	int getCount(CarAccessAlarmBean bean);

	int insertCarAccessMessage(CarAccessBean bean);

	String getUerIdByCar(CarAccessBean bean);

	int checkRepeatRequest(CarAccessBean bean);


}
