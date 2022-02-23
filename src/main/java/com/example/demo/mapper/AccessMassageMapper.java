package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.AlarmBean;
import com.example.demo.model.ApplyMessageBean;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.VisitorMessageBean;

@Repository
public interface AccessMassageMapper {

	List<AccessMessageBean> getAccessMessage(AccessMessageBean bean);

	AccessMessageBean getAccessById(AccessMessageBean bean);

	int handleMessage(AccessMessageBean bean);

	Map<String, Object> getPersonMessage(AccessMessageBean bean);

	List<Map<String, Object>> getAccessLog(AccessMessageBean bean);

	List<AccessMessageBean> getAccessByApparatus(AccessMessageBean bean);

	int getCount(AccessMessageBean bean);

	Map<String, Object> getGroupByPerson(String person_id);

	int insertAccessMessage(AccessMessageBean accessMessageBean);

	int getAccessCount(AccessMessageBean bean);

	int getVisitCount(AccessMessageBean bean);

	int getAlarmCount(AccessMessageBean bean);

	int getHandleCount(AccessMessageBean bean);

	List<AccessMessageBean> getAccessMessageMain(AccessMessageBean bean);

	Map<String, Object> getApparatusById(String serialNo);

	String getPerson(String person_id);

	int getTemperatureCount(AccessMessageBean bean);

	int getAccessUnusualCount(AccessMessageBean bean);

	int getAccessStrangerCount(AccessMessageBean bean);

	int getAccessAlarmCount(AccessMessageBean bean);

	int getVisitAlarmCount(AccessMessageBean bean);

	int getCarAlarmCount(AccessMessageBean bean);

	AlarmBean getAccessAlarmById(int id);

	void insertAccessAlarmMessage(AlarmBean accessAlarmBean);

	ApplyMessageBean getApplyNum(AccessMessageBean accessMessageBean);

	int updateApplyStatus(ApplyMessageBean applyMessageBean);

	String getDutyDynamics(String person_id);

	void updateDutyDynamics(Map<String, Object> map);

}
