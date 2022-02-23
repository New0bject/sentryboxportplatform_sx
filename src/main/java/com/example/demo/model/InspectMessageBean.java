package com.example.demo.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class InspectMessageBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String event_name;
	private String group_id;
	private String group_name;
	private String handle_user;
	private String handle_user_name;
	private String handle_time;
	private String handle_status;
	private String attribution_dept;
	private int totalPage; // 总页数
	private int page; // 计算页数
	private int lineCount; // 每次加载条数
	private String start_time;
	private String end_time;
	private String create_time;
	private String real_name;
	
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getHandle_user_name() {
		return handle_user_name;
	}
	public void setHandle_user_name(String handle_user_name) {
		this.handle_user_name = handle_user_name;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
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
	public String getHandle_status() {
		return handle_status;
	}
	public void setHandle_status(String handle_status) {
		this.handle_status = handle_status;
	}
	public String getAttribution_dept() {
		return attribution_dept;
	}
	public void setAttribution_dept(String attribution_dept) {
		this.attribution_dept = attribution_dept;
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

	
}

