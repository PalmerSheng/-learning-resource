package com.wms.controller.assist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.service.assist.SupplyInfoService;

@Controller
@SuppressWarnings("all")
@RequestMapping("SupplyInfoController")
public class SupplyInfoController {
	@Autowired
    private SupplyInfoService service;
	
		//新增
		@RequestMapping("/insertinfo")
		@ResponseBody
		public BackMessage InsertStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
			BackMessage backMessage =null;
			backMessage = service.InsertSupplyInfo(req, res);
			return backMessage;
			}
		//修改
		@RequestMapping("/updateinfo")
		@ResponseBody
		public BackMessage UpdateStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
			BackMessage backMessage =null;
			backMessage = service.UpdateSupplyInfo(req, res);
			return backMessage;
			}
		//删除
		@RequestMapping("/deleteinfo")
		@ResponseBody
		public BackMessage DeleteStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
			BackMessage backMessage =null;
			backMessage = service.DeleteSupplyInfo(req, res);
			return backMessage;
			}
		//查询
		@RequestMapping("/info")
		@ResponseBody
		public BackMessage Info(HttpServletRequest req, HttpServletResponse res) {
			BackMessage backMessage =null;
			backMessage = service.Info(req, res);
			return backMessage;
			}
	
}
