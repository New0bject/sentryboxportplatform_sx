package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

public class AccessMessageBean implements Serializable{

	/**
	 *   出入管理javaBean
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String apparatus_id;
	private String apparatus_name;
	private String address;
	private String event_type;
	private String person_id;
	private String person_name;
	private String group_id;
	private String group_name;
	private String car_no;
	private float temperature;
	private String handle_result;
	private String handle_status;
	private String handle_time;
	private String handle_user;
	private String create_time;
	private String create_user;
	private String img_url;
	private String start_time;
	private String end_time;
	private int totalPage; // 总页数
	private int page; // 计算页数
	private int lineCount; // 每次加载条数
	private String save_img;
	private String attribution_dept;
	private List<String> attribution_dept_list;
	private String role_id;
	private String handle_user_name;
	private String access_type;
	
	public String getAccess_type() {
		return access_type;
	}
	public void setAccess_type(String access_type) {
		this.access_type = access_type;
	}
	public List<String> getAttribution_dept_list() {
		return attribution_dept_list;
	}
	public void setAttribution_dept_list(List<String> attribution_dept_list) {
		this.attribution_dept_list = attribution_dept_list;
	}
	public String getHandle_user_name() {
		return handle_user_name;
	}
	public void setHandle_user_name(String handle_user_name) {
		this.handle_user_name = handle_user_name;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getAttribution_dept() {
		return attribution_dept;
	}
	public void setAttribution_dept(String attribution_dept) {
		this.attribution_dept = attribution_dept;
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
	public String getHandle_user() {
		return handle_user;
	}
	public void setHandle_user(String handle_user) {
		this.handle_user = handle_user;
	}
	public String getHandle_status() {
		return handle_status;
	}
	public void setHandle_status(String handle_status) {
		this.handle_status = handle_status;
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
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	public String getPerson_name() {
		return person_name;
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
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public String getHandle_result() {
		return handle_result;
	}
	public void setHandle_result(String handle_result) {
		this.handle_result = handle_result;
	}
	public String getHandle_time() {
		return handle_time;
	}
	public void setHandle_time(String handle_time) {
		this.handle_time = handle_time;
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

	@Override
	public String toString() {
		return "AccessMessageBean{" +
				"id=" + id +
				", apparatus_id='" + apparatus_id + '\'' +
				", apparatus_name='" + apparatus_name + '\'' +
				", address='" + address + '\'' +
				", event_type='" + event_type + '\'' +
				", person_id='" + person_id + '\'' +
				", person_name='" + person_name + '\'' +
				", group_id='" + group_id + '\'' +
				", group_name='" + group_name + '\'' +
				", car_no='" + car_no + '\'' +
				", temperature=" + temperature +
				", handle_result='" + handle_result + '\'' +
				", handle_status='" + handle_status + '\'' +
				", handle_time='" + handle_time + '\'' +
				", handle_user='" + handle_user + '\'' +
				", create_time='" + create_time + '\'' +
				", create_user='" + create_user + '\'' +
				", img_url='" + img_url + '\'' +
				", start_time='" + start_time + '\'' +
				", end_time='" + end_time + '\'' +
				", totalPage=" + totalPage +
				", page=" + page +
				", lineCount=" + lineCount +
				", save_img='" + save_img + '\'' +
				", attribution_dept='" + attribution_dept + '\'' +
				", attribution_dept_list=" + attribution_dept_list +
				", role_id='" + role_id + '\'' +
				", handle_user_name='" + handle_user_name + '\'' +
				", access_type='" + access_type + '\'' +
				'}';
	}
}
