package com.wms.controller.storemanagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.service.storemanagement.OnOrOutStoreService;

//入库与出库
@Controller
@SuppressWarnings("all")
@RequestMapping("OnOrOutStoreController")
public class OnOrOutStoreController {

	@Autowired
	private OnOrOutStoreService service;

	@RequestMapping(value = "/onStore")
	@ResponseBody
	public BackMessage onStore(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.onStore(req, res);
		return backMessage;
	}
	
	@RequestMapping(value = "/onStore01")
	@ResponseBody
	public BackMessage onStore01(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.onStore01(req, res);
		return backMessage;
	}
	
	@RequestMapping(value = "/outStore")
	@ResponseBody
	public BackMessage outStore(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.outStore(req, res);
		return backMessage;
	}
	
	@RequestMapping(value = "/outStore01")
	@ResponseBody
	public BackMessage outStore01(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.outStore01(req, res);
		return backMessage;
	}
}
