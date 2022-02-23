package com.example.demo.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class RiskAlarmBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String apparatus_id;
	private String apparatus_name;
	private String address;
	private String create_time;
	private int visit_id;
	private String alarm_type;
	private String alarm_message;
	private String handle_status;
	private String handle_message;
	private String handle_user;
	private String handle_time;
	private int totalPage; // 总页数
	private int page; // 计算页数
	private int lineCount; // 每次加载条数
	private String start_time;
	private String end_time;
	private String attribution_dept;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApparatus_id() {
		return apparatus_id;
	}
	public void setApparatus_id(String apparatus_id) {
		this.apparatus_id = apparatus_id;
	}
	public String getApparatus_name() {
		return apparatus_name;
	}
	public void setApparatus_name(String apparatus_name) {
		this.apparatus_name = apparatus_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}
	public String getAlarm_type() {
		return alarm_type;
	}
	public void setAlarm_type(String alarm_type) {
		this.alarm_type = alarm_type;
	}
	public String getAlarm_message() {
		return alarm_message;
	}
	public void setAlarm_message(String alarm_message) {
		this.alarm_message = alarm_message;
	}
	public String getHandle_status() {
		return handle_status;
	}
	public void setHandle_status(String handle_status) {
		this.handle_status = handle_status;
	}
	public String getHandle_message() {
		return handle_message;
	}
	public void setHandle_message(String handle_message) {
		this.handle_message = handle_message;
	}
	public String getHandle_user() {
		return handle_user;
	}
	public void setHandle_user(String handle_user) {
		this.handle_user = handle_user;
	}
	public String getHandle_time() {
		return handle_time;
	}
	public void setHandle_time(String handle_time) {
		this.handle_time = handle_time;
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
	public String getAttribution_dept() {
		return attribution_dept;
	}
	public void setAttribution_dept(String attribution_dept) {
		this.attribution_dept = attribution_dept;
	}

}

