package com.wms.model;

public class DataBase {

	private int id;
	private String url = "";
	private String user_name = "";
	private String pass_word = "";
	private String driver_type = "";
	private String db_name = "";
	private String place = "";
	private String duty = "";
	
	private String mySqlPrefix = "jdbc:mysql://";
	private String mySqlSuffix = "?useUnicode=true&amp;characterEncoding=utf8&amp;allowMultiQueries=true&amp;autoReconnect=true&amp;failOverReadOnly=false";
	private String mySqlDriver = "com.mysql.jdbc.Driver";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	public String getDb_name() {
		return db_name;
	}
	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getDriver_type() {
		return driver_type;
	}
	public void setDriver_type(String driver_type) {
		this.driver_type = driver_type;
	}
	
	public String getUrlFull() {
		String urlFull = mySqlPrefix + url + mySqlSuffix;
		return urlFull;
	}
}
