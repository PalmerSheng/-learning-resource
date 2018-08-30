package com.wxl.practice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import com.wxl.commons.PubResJsonObj;
import com.wxl.commons.SysPubCommons;
import com.wxl.model.CollegeInfo;
import com.wxl.practice.mapper.CollegeMapper;
import com.wxl.pratice.service.CollegeOrganService;
@Service
public class CollegeOrganServiceImpl implements CollegeOrganService{
     private Logger logger=Logger.getLogger(CollegeOrganServiceImpl.class);
	@Resource
private CollegeMapper CollegeMapper;
	public Map<String, Object> College_getCollegeInfo(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String,Object> object=new HashMap<String, Object>();
        String collagename=req.getParameter("collageName");
        Integer limit=(req.getParameter("limit")==null?3:Integer.parseInt(req.getParameter("limit").trim()));
        Integer offset=(req.getParameter("offset")==null?0:Integer.parseInt(req.getParameter("offset").trim()));
		ArrayList<CollegeInfo> obj=CollegeMapper.College_getCollegeInfo(collagename, limit, offset);
		int count=CollegeMapper.College_getTotal(collagename);
		object.put("total", count);
		object.put("rows", obj);
		return object;
	}
	@Override
	public Map<String, Object> TestDB(HttpServletRequest req,
			HttpServletResponse res) {
		Map<String,Object> object=new HashMap<String, Object>();
		ArrayList<CollegeInfo> obj=CollegeMapper.TestDB();
		String msg="连接成功";
		object.put("msg", msg);
		object.put("list", obj);
		return object;
		
	}
	@Override
	public PubResJsonObj College_updCollegeInfo(HttpServletRequest req,
			HttpServletResponse res) {
		PubResJsonObj pubResJsonObj=null;
		try {
			String collagename=(req.getParameter("collagename")==null?"":req.getParameter("collagename").trim());
			String collagecode=(req.getParameter("collagecode")==null?"":req.getParameter("collagecode").trim());
			String collageid=(req.getParameter("collageid")==null?"":req.getParameter("collageid").trim());
			CollegeInfo  collegeInfo=new CollegeInfo();
			collegeInfo.setCollagecode(collagecode);
			collegeInfo.setCollagename(collagename);
			collegeInfo.setId(collageid);
			CollegeMapper.College_updCollegeInfo(collegeInfo);
			logger.info("进行了修改操作");
			pubResJsonObj=SysPubCommons.GetJsonObj("0", "修改成功");
			return pubResJsonObj;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage());
		}
		
	}
	@Override
	public String Collage_forwardEdit(HttpServletRequest req,
			HttpServletResponse res) {
		String collageId=(req.getParameter("collageid")==null?"":req.getParameter("collageid").trim());
		CollegeInfo collegeInfo=CollegeMapper.Collage_getCollageId(collageId);
		req.setAttribute("collageinfo", collegeInfo);
		return "/collegeInfo/editServer";
	}
	@Override
	public PubResJsonObj College_delCollegeInfo(HttpServletRequest req,
			HttpServletResponse res) {
		PubResJsonObj pubResJsonObj=null;
		try {
			String collageId=(req.getParameter("collageid")==null?"":req.getParameter("collageid").trim());
			System.out.println("id  "+collageId);
			CollegeMapper.College_del(collageId);
			logger.info("进行了删除操作");
			pubResJsonObj=SysPubCommons.GetJsonObj("0", "删除成功");
			return pubResJsonObj;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage());
		}
		

	}
	public PubResJsonObj listdel(HttpServletRequest req,HttpServletResponse res,String arraylist){
		PubResJsonObj pubResJsonObj=null;
		try {
			String strlist=arraylist;
			System.out.println("批量删除");
			System.out.println(arraylist);
			String[] array=strlist.split(",");
			for(int i=0;i<array.length;i++){
				String collageId=array[i];
				CollegeMapper.College_del(collageId);
			}
			logger.info("进行了删除操作");
			pubResJsonObj=SysPubCommons.GetJsonObj("0", "删除成功");
			return pubResJsonObj;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e.getMessage());
		}
		
	}
	@Override
	public PubResJsonObj College_insertInfo(HttpServletRequest req,
			HttpServletResponse res) {

		PubResJsonObj pubResJsonObj=null;
		String collagecode=req.getParameter("collagecode");
		String collagename=req.getParameter("collagename");
		CollegeMapper.College_insertInfo(collagecode, collagename);
		logger.info("进行了新增操作");
		pubResJsonObj=SysPubCommons.GetJsonObj("0", "新增成功");
		return pubResJsonObj;
	}

}
