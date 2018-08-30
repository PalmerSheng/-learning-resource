package com.sf.model;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author : sf
 * @time   : 2018年8月4日  上午11:38:00 
 * @TODO   :系统日志实体类
 */
@Repository(value = "log")
public class Log {
    private String id;      //日志编号
    private String userid;  //用户名
    private String time;    //时间
   
    private String detail;  //详情
    private String ip;      //ip地址
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

    
    
}
