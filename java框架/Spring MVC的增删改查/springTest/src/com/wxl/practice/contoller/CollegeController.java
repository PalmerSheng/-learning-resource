package com.wxl.practice.contoller ;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.wxl.commons.PubResJsonObj;
import com.wxl.commons.SysPubCommons;
import com.wxl.pratice.service.CollegeOrganService;



@Controller
@RequestMapping("College")
public class CollegeController {

	@Resource
	private CollegeOrganService CollegeOrganServiceImpl;
	//最好名字和实现的类一致
	
	/**
	 * 加载表格
	 * */
	@RequestMapping("/sel")
	@ResponseBody
	public Map<String, Object> College_selectCollege(HttpServletRequest req,HttpServletResponse res){
		Map<String, Object> obj=CollegeOrganServiceImpl.College_getCollegeInfo(req, res);
		return obj;
	}
	
	//批量删除第二种方法
	@RequestMapping("/listdel2")
	@ResponseBody
	public PubResJsonObj test(HttpServletRequest req,HttpServletResponse res){
		
		PubResJsonObj obj=null;
		//
		String id = req.getParameter("arraylist");
		//做闭右开
		String str = id.substring(1,id.length()-1).replace("\"", "");
		//String[] arr = str.split(",");
		try {
			obj=CollegeOrganServiceImpl.listdel(req, res,str);
		} catch (Exception e) {
			obj = SysPubCommons.GetJsonObj("1", "删除操作失败:" + e.getMessage());
		}
		return obj;
		 
	}
	
	
	/**
	 * 更新表格
	 * */
	@RequestMapping("upd")
	@ResponseBody
	public PubResJsonObj upd(HttpServletRequest req,HttpServletResponse res){
		PubResJsonObj obj=null;
		try {
			obj=CollegeOrganServiceImpl.College_updCollegeInfo(req, res);
		} catch (Exception e) {
		   obj = SysPubCommons.GetJsonObj("1", "修改操作失败:" + e.getMessage());
		}
		return obj;
		 
	}
	/**
	 * 编辑跳转路径
	 * 
	 * */
	@RequestMapping("/forwardEdit")
	public String Collage_forwardEdit(HttpServletRequest req,HttpServletResponse res){
		String path=CollegeOrganServiceImpl.Collage_forwardEdit(req, res);
		return path;
	}
	@RequestMapping("/del")
	@ResponseBody
	public PubResJsonObj del(HttpServletRequest req,HttpServletResponse res){
		PubResJsonObj obj=null;
		try {
			obj=CollegeOrganServiceImpl.College_delCollegeInfo(req, res);
		} catch (Exception e) {
			obj = SysPubCommons.GetJsonObj("1", "删除操作失败:" + e.getMessage());
		}
		return obj;
	}
	
	@RequestMapping("/listdel")
	@ResponseBody
	public PubResJsonObj listdel(HttpServletRequest req,HttpServletResponse res,@RequestParam("arraylist[]")String arraylist){
		PubResJsonObj obj=null;
		try {
			obj=CollegeOrganServiceImpl.listdel(req, res,arraylist);
		} catch (Exception e) {
			obj = SysPubCommons.GetJsonObj("1", "删除操作失败:" + e.getMessage());
		}
		return obj;
	}
	@RequestMapping("/add")
	@ResponseBody
	public PubResJsonObj add(HttpServletRequest req,HttpServletResponse res){
		PubResJsonObj obj=null;
		try {
			obj=CollegeOrganServiceImpl.College_insertInfo(req, res);
		} catch (Exception e) {
			obj = SysPubCommons.GetJsonObj("1", "新增操作失败:" + e.getMessage());
		}
		return obj;
	}
}

