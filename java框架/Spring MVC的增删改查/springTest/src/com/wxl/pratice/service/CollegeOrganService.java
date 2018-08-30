package com.wxl.pratice.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

import com.wxl.commons.PubResJsonObj;

public interface CollegeOrganService {

	
	public Map<String, Object> College_getCollegeInfo(HttpServletRequest req,HttpServletResponse res);
	public Map<String, Object> TestDB(HttpServletRequest req,HttpServletResponse res);
	public PubResJsonObj College_updCollegeInfo(HttpServletRequest req,HttpServletResponse res);
	public PubResJsonObj College_delCollegeInfo(HttpServletRequest req,HttpServletResponse res);
	public PubResJsonObj listdel(HttpServletRequest req,HttpServletResponse res,String arraylist);

	
	public PubResJsonObj College_insertInfo(HttpServletRequest req,HttpServletResponse res);

	public String Collage_forwardEdit(HttpServletRequest req,HttpServletResponse res);
}
