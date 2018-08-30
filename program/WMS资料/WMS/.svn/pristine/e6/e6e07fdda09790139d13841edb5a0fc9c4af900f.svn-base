package com.wms.controller.storemanagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.service.storemanagement.SumStoreService;

//库存盘点
@Controller
@SuppressWarnings("all")
@RequestMapping("SumStoreController")
public class SumStoreController {

	@Autowired
	private SumStoreService service;

	//获取货物信息
	@RequestMapping(value = "/sumStore")
	@ResponseBody
	public BackMessage sumStore(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.sumStore(req, res);
		return backMessage;
	}
	
}
