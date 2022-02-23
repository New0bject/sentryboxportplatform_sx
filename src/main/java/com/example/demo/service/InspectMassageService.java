package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ApparatusCategoryBean;
import com.example.demo.model.ApparatusMessageBean;
import com.example.demo.model.InspectMessageBean;
import com.example.demo.model.ResultBeanRet;

public interface InspectMassageService {

	int getCount(InspectMessageBean bean);

	List<InspectMessageBean> getInspectMessage(InspectMessageBean bean);

	ResultBeanRet updateInspectMessage(InspectMessageBean bean);
	
	void insertInspectMessage(InspectMessageBean bean);


}
