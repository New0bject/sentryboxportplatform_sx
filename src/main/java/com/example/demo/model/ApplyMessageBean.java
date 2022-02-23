package com.example.demo.model;

import java.io.Serializable;

public class ApplyMessageBean implements Serializable{

	/**
	 *   请假信息javaBean
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String vacate_apply_number;
	private String user_id;
	private String user_name;
	private String squad_id;
	private String squadron_id;
	private String process_id;
	private Integer vacate_type;
	private String start_time;
	private String end_time;
	private String time_length;
	private String return_time;
	private String vacate_cause;
	private String egress_place;
	private String Illness_description;
	private String hospital;
	private String alcohol_value;
	private String temperature_value;
	private String create_time;
	private String update_time;
	private Integer is_exist;
	private Integer apply_state;
	private String vacate_name;
	
	public String getVacate_name() {
		return vacate_name;
	}
	public void setVacate_name(String vacate_name) {
		this.vacate_name = vacate_name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVacate_apply_number() {
		return vacate_apply_number;
	}
	public void setVacate_apply_number(String vacate_apply_number) {
		this.vacate_apply_number = vacate_apply_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getSquad_id() {
		return squad_id;
	}
	public void setSquad_id(String squad_id) {
		this.squad_id = squad_id;
	}
	public String getSquadron_id() {
		return squadron_id;
	}
	public void setSquadron_id(String squadron_id) {
		this.squadron_id = squadron_id;
	}
	public String getProcess_id() {
		return process_id;
	}
	public void setProcess_id(String process_id) {
		this.process_id = process_id;
	}
	public Integer getVacate_type() {
		return vacate_type;
	}
	public void setVacate_type(Integer vacate_type) {
		this.vacate_type = vacate_type;
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
	public String getTime_length() {
		return time_length;
	}
	public void setTime_length(String time_length) {
		this.time_length = time_length;
	}
	public String getReturn_time() {
		return return_time;
	}
	public void setReturn_time(String return_time) {
		this.return_time = return_time;
	}
	public String getVacate_cause() {
		return vacate_cause;
	}
	public void setVacate_cause(String vacate_cause) {
		this.vacate_cause = vacate_cause;
	}
	public String getEgress_place() {
		return egress_place;
	}
	public void setEgress_place(String egress_place) {
		this.egress_place = egress_place;
	}
	public String getIllness_description() {
		return Illness_description;
	}
	public void setIllness_description(String illness_description) {
		Illness_description = illness_description;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getAlcohol_value() {
		return alcohol_value;
	}
	public void setAlcohol_value(String alcohol_value) {
		this.alcohol_value = alcohol_value;
	}
	public String getTemperature_value() {
		return temperature_value;
	}
	public void setTemperature_value(String temperature_value) {
		this.temperature_value = temperature_value;
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
	public Integer getIs_exist() {
		return is_exist;
	}
	public void setIs_exist(Integer is_exist) {
		this.is_exist = is_exist;
	}
	public Integer getApply_state() {
		return apply_state;
	}
	public void setApply_state(Integer apply_state) {
		this.apply_state = apply_state;
	}


}
