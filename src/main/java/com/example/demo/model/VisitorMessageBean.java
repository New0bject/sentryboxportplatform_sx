package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

public class VisitorMessageBean implements Serializable{

	/**
	 *   访客管理javaBean
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String id_card;
	private String phone;
	private String temperature;
	private String img_picture;
	private String car_no;
	private String health_code;
	private String visit_group;
	private String visit_person;
	private String visit_person_id;
	private String visit_reason;
	private String rank;
	private String create_time;
	private String leave_time;
	private String create_user;
	private String apparatus_name;
	private String address;
	private String event_type;
	private String start_time;
	private String end_time;
	private int totalPage; // 总页数
	private int page; // 计算页数
	private int lineCount; // 每次加载条数
	private String attribution_dept;
	private List<String> attribution_dept_list;
	private String person_id;
	private String visitor_type;
	private String visit_status;
	
	public String getLeave_time() {
		return leave_time;
	}
	public void setLeave_time(String leave_time) {
		this.leave_time = leave_time;
	}
	public String getVisit_status() {
		return visit_status;
	}
	public void setVisit_status(String visit_status) {
		this.visit_status = visit_status;
	}
	public String getVisit_person_id() {
		return visit_person_id;
	}
	public void setVisit_person_id(String visit_person_id) {
		this.visit_person_id = visit_person_id;
	}
	public List<String> getAttribution_dept_list() {
		return attribution_dept_list;
	}
	public void setAttribution_dept_list(List<String> attribution_dept_list) {
		this.attribution_dept_list = attribution_dept_list;
	}
	public String getVisitor_type() {
		return visitor_type;
	}
	public void setVisitor_type(String visitor_type) {
		this.visitor_type = visitor_type;
	}
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	public String getAttribution_dept() {
		return attribution_dept;
	}
	public void setAttribution_dept(String attribution_dept) {
		this.attribution_dept = attribution_dept;
	}
	public String getVisit_group() {
		return visit_group;
	}
	public void setVisit_group(String visit_group) {
		this.visit_group = visit_group;
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
	public String getEvent_type() {
		return event_type;
	}
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getImg_picture() {
		return img_picture;
	}
	public void setImg_picture(String img_picture) {
		this.img_picture = img_picture;
	}
	public String getCar_no() {
		return car_no;
	}
	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}
	public String getHealth_code() {
		return health_code;
	}
	public void setHealth_code(String health_code) {
		this.health_code = health_code;
	}
	public String getVisit_person() {
		return visit_person;
	}
	public void setVisit_person(String visit_person) {
		this.visit_person = visit_person;
	}
	public String getVisit_reason() {
		return visit_reason;
	}
	public void setVisit_reason(String visit_reason) {
		this.visit_reason = visit_reason;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
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

}
