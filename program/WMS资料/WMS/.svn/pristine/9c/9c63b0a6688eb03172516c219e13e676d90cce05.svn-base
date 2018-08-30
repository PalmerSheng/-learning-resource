package com.wms.controller.storemanagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.service.storemanagement.BackOrTakeStoreService;

//仓库退料与取料
@Controller
@SuppressWarnings("all")
@RequestMapping("BackOrTakeStoreController")
public class BackOrTakeStoreController {

	@Autowired
	private BackOrTakeStoreService service;
	
	//退料
	@RequestMapping(value = "/backStore")
	@ResponseBody
	public BackMessage backStore(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.backStore(req, res);
		return backMessage;
	}
	@RequestMapping(value = "/backStore01")
	@ResponseBody
	public BackMessage backStore01(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.backStore01(req, res);
		return backMessage;
	}
	
	//取料
	@RequestMapping(value = "/takeStore")
	@ResponseBody
	public BackMessage takeStore(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.takeStore(req, res);
		return backMessage;
	}
	@RequestMapping(value = "/takeStore01")
	@ResponseBody
	public BackMessage takeStore01(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.takeStore01(req, res);
		return backMessage;
	}

}
