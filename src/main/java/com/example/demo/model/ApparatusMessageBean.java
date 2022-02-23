package com.example.demo.model;

import java.io.Serializable;

public class ApparatusMessageBean implements Serializable{

	/**
	 * 设备基础信息javabean
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String apparatus_name;
	private Integer apparatus_category_id;
	private String address;
	private String lat;
	private String lng;
	private String manage_unit_name;
	private Integer competent_unit_id;
	private String charge_person_id;
	private Integer is_intact;
	private String remark;
	private Integer parent_id;
	private String create_time;
	private String update_time;
	private String create_user_id;
	private String update_user_id;
	private String attribution_dept;
	
	public String getAttribution_dept() {
		return attribution_dept;
	}
	public void setAttribution_dept(String attribution_dept) {
		this.attribution_dept = attribution_dept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApparatus_name() {
		return apparatus_name;
	}
	public void setApparatus_name(String apparatus_name) {
		this.apparatus_name = apparatus_name;
	}
	public Integer getApparatus_category_id() {
		return apparatus_category_id;
	}
	public void setApparatus_category_id(Integer apparatus_category_id) {
		this.apparatus_category_id = apparatus_category_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getManage_unit_name() {
		return manage_unit_name;
	}
	public void setManage_unit_name(String manage_unit_name) {
		this.manage_unit_name = manage_unit_name;
	}
	public Integer getCompetent_unit_id() {
		return competent_unit_id;
	}
	public void setCompetent_unit_id(Integer competent_unit_id) {
		this.competent_unit_id = competent_unit_id;
	}
	public String getCharge_person_id() {
		return charge_person_id;
	}
	public void setCharge_person_id(String charge_person_id) {
		this.charge_person_id = charge_person_id;
	}
	public Integer getIs_intact() {
		return is_intact;
	}
	public void setIs_intact(Integer is_intact) {
		this.is_intact = is_intact;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
