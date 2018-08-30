package com.sf.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BackMessage {
	//信息编号
	private int code;
	//信息内容
	private String message;
	//数目
	private int count;
	//信息map
//	private  final Map<String, Object> datas = new HashMap<String, Object>();

	private List<?> data;
	
	
	
	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public List<?> getData() {
		return data;
	}



	public void setData(List<?> data) {
		this.data = data;
	}






	public BackMessage(int code, String message, int count, List<?> data) {
		super();
		this.code = code;
		this.message = message;
		this.count = count;
		this.data = data;
	}



	
	
	
	

}
