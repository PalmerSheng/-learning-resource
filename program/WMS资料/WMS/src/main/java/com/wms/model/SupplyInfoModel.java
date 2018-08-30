package com.wms.model;

public class SupplyInfoModel {
	private String id="";
	private String supply_name="";
	private String supply_code="";
	private String tel="";
	private String duty_name="";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSupply_name() {
		return supply_name;
	}
	public void setSupply_name(String supply_name) {
		this.supply_name = supply_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSupply_code() {
		return supply_code;
	}
	public void setSupply_code(String supply_code) {
		this.supply_code = supply_code;
	}
	public String getDuty_name() {
		return duty_name;
	}
	public void setDuty_name(String duty_name) {
		this.duty_name = duty_name;
	}

}
