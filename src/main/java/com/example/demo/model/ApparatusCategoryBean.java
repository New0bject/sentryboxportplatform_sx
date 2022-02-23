package com.example.demo.model;

import java.io.Serializable;

public class ApparatusCategoryBean implements Serializable{

	/**
	 * 设备基础信息javabean
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String group_id;
	private String apparatus_name;
	private String apparatus_category_name;
	private String apparatus_category_id;
	private Integer parent_id;
	private String create_time;
	private String update_time;
	private String create_user_id;
	private String update_user_id;
	private String remark;
	private String attribution_dept;
	
	public String getAttribution_dept() {
		return attribution_dept;
	}
	public void setAttribution_dept(String attribution_dept) {
		this.attribution_dept = attribution_dept;
	}
	
	public String getApparatus_name() {
		return apparatus_name;
	}
	public void setApparatus_name(String apparatus_name) {
		this.apparatus_name = apparatus_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getApparatus_category_id() {
		return apparatus_category_id;
	}
	public void setApparatus_category_id(String apparatus_category_id) {
		this.apparatus_category_id = apparatus_category_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getApparatus_category_name() {
		return apparatus_category_name;
	}
	public void setApparatus_category_name(String apparatus_category_name) {
		this.apparatus_category_name = apparatus_category_name;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}
	public String getUpdate_user_id() {
		return update_user_id;
	}
	public void setUpdate_user_id(String update_user_id) {
		this.update_user_id = update_user_id;
	}

	
}
