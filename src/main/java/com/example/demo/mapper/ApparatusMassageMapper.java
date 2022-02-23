package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.ApparatusCategoryBean;
import com.example.demo.model.ApparatusMessageBean;

@Repository
public interface ApparatusMassageMapper {

	public List<ApparatusMessageBean> getApparatusMessage(ApparatusCategoryBean bean);

	public List<ApparatusCategoryBean> getApparatusCategory();

	public List<ApparatusCategoryBean> getApparatusByGroup(
			ApparatusCategoryBean bean);

}
