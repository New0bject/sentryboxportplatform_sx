package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.AccessMessageBean;
import com.example.demo.model.RiskAlarmBean;
import com.example.demo.model.VisitorMessageBean;

@Repository
public interface RistMassageMapper {

	int getCount(RiskAlarmBean bean);

	List<RiskAlarmBean> getAlarmList(RiskAlarmBean bean);


}
