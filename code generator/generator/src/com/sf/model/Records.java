package com.sf.model;

import java.util.Date;

public class Records {
    private Integer id;

    private String userid;

    private String remark;

    private String troublemeet;

    private Date writetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getTroublemeet() {
        return troublemeet;
    }

    public void setTroublemeet(String troublemeet) {
        this.troublemeet = troublemeet == null ? null : troublemeet.trim();
    }

    public Date getWritetime() {
        return writetime;
    }

    public void setWritetime(Date writetime) {
        this.writetime = writetime;
    }
}