package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ApparatusCategoryBean;
import com.example.demo.model.ApparatusMessageBean;

public interface ApparatusMassageService {

	List<ApparatusMessageBean> getApparatusMessage(ApparatusCategoryBean bean);

	List<ApparatusCategoryBean> getApparatusCategory();

	List<ApparatusCategoryBean> getApparatusByGroup(ApparatusCategoryBean bean);

}
