package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.MonitorMessageBean;

@Repository
public interface MonitorMassageMapper {

	List<MonitorMessageBean> getMonitorMessage(MonitorMessageBean bean);

	MonitorMessageBean getMonitorById(MonitorMessageBean bean);

	int getCount(MonitorMessageBean bean);

	Map<String, Object> getGroupByPerson(String string);

	Map<String, Object> getApparatusById(String string);

	int insertMonitorMessage(MonitorMessageBean monitorMessageBean);


}
