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
public interface BaseMassageMapper {

	List<Map<String, Object>> checkDept(Map<String, Object> paramMap);

	String getCidByPerson(String visit_person_id);


}
