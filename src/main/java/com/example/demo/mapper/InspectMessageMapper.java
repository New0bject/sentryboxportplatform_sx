package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.ApparatusCategoryBean;
import com.example.demo.model.ApparatusMessageBean;
import com.example.demo.model.InspectMessageBean;

@Repository
public interface InspectMessageMapper {

	public void insertInspectMessage(InspectMessageBean bean);

	public int getCount(InspectMessageBean bean);

	public List<InspectMessageBean> getInspectMessage(InspectMessageBean bean);

	public int updateInspectMessage(InspectMessageBean bean);

}
