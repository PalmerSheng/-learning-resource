package com.wms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.service.TestService;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private TestService TestService;
	
	@RequestMapping("getInfo")
	@ResponseBody
	public void getInfo(){
		System.out.println(TestService.getInfo());
	}
}
