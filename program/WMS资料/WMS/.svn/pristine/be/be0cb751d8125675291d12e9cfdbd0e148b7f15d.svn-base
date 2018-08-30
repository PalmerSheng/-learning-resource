package com.wms.controller.storemanagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.common.DataSourceContextHolder;
import com.wms.model.DataBase;
import com.wms.service.storemanagement.DataBaseService;
import com.wms.util.ChooseDB;
import com.wms.util.ChooseDataSourse;

//数据库管理
@Controller
@SuppressWarnings("all")
@RequestMapping("DataBaseController")
public class DataBaseController {

	@Autowired
	private DataBaseService service;

	@Autowired
	private ChooseDB chooseDB;
	
	@RequestMapping(value = "/dataBaseList", method = RequestMethod.GET)
	@ResponseBody
	public BackMessage dataBaseList(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.dataBaseList(req, res);
		return backMessage;
	}
	
	@RequestMapping(value = "/selDB", method = RequestMethod.GET)
	@ResponseBody
	public BackMessage selDB(HttpServletRequest req, HttpServletResponse res) {

		//chooseDataSourse.chooseDB();
		List<DataBase> list = chooseDB.showDB(null);
		System.out.println("ashjahdhsjkd");
		//BackMessage backMessage //= service.dataBaseList(req, res);
		return new BackMessage(0, null,list);
	}
	
	@RequestMapping(value = "/setDB", method = RequestMethod.GET)
	@ResponseBody
	public BackMessage setDB(HttpServletRequest req, HttpServletResponse res) {

		//chooseDataSourse.setDB();
		DataSourceContextHolder.setDbType("w");
		//BackMessage backMessage //= service.dataBaseList(req, res);
		return new BackMessage(0, null);
	}
	
}
