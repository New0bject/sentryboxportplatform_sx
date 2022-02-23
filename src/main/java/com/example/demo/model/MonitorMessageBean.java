package com.example.demo.model;

import java.io.Serializable;

public class MonitorMessageBean implements Serializable{

	/**
	 *   智能监控javaBean
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String apparatus_id;
	private String apparatus_name;
	private String address;
	private String person_id;
	private String person_name;
	private String sex;
	private String group_id;
	private String group_name;
	private float temperature;
	private String create_time;
	private String create_user;
	private String img_url;
	private String start_time;
	private String end_time;
	private int totalPage; // 总页数
	private int page; // 计算页数
	private int lineCount; // 每次加载条数
	private String save_img;
	private String age;
	private String attribution_dept;
	
	public String getAttribution_dept() {
		return attribution_dept;
	}
	public void setAttribution_dept(String attribution_dept) {
		this.attribution_dept = attribution_dept;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPerson_name() {
		return person_name;
	}
	public float getTemperature() {
		return temperature;
	}
	public String getSave_img() {
		return save_img;
	}
	public void setSave_img(String save_img) {
		this.save_img = save_img;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getLineCount() {
		return lineCount;
	}
	public void setLineCount(int lineCount) {
		this.lineCount = lineCount;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getApparatus_name() {
		return apparatus_name;
	}
	public void setApparatus_name(String apparatus_name) {
		this.apparatus_name = apparatus_name;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApparatus_id() {
		return apparatus_id;
	}
	public void setApparatus_id(String apparatus_id) {
		this.apparatus_id = apparatus_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	

}
