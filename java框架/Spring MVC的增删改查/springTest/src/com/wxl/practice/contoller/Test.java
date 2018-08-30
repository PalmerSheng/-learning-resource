package com.wxl.practice.contoller;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wxl.model.CollegeInfo;
import com.wxl.pratice.service.CollegeOrganService;


@Controller
@RequestMapping("wxl")
public class Test {
	@Resource
	private CollegeOrganService CollegeOrganServiceImpl;

	@RequestMapping("/test")
	public void College_selectCollege(HttpServletRequest req,HttpServletResponse res){

		Map<String, Object> obj=CollegeOrganServiceImpl.TestDB(req, res);
		String msg=(String)obj.get("msg");
		ArrayList<CollegeInfo>  list=(ArrayList<CollegeInfo>)obj.get("list");
		System.out.println("测试");
		System.out.println(msg);
		for(int i=0;i<list.size();i++){
			CollegeInfo temp=list.get(i);
			System.out.println(temp.getCollagecode()+" :"+temp.getCollagename());
		}
	}
}
