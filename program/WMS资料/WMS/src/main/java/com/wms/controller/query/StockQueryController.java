package com.wms.controller.query;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.service.query.StockQueryService;

@Controller
@SuppressWarnings("all")
@RequestMapping("StockQueryInfo")
public class StockQueryController {
	@Autowired
	private  StockQueryService service;
	//加载表
		@RequestMapping("/Getinfo")
		@ResponseBody
			public BackMessage GetStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
			BackMessage backMessage =null;
			backMessage = service.GetStockInfo(req, res);
			return backMessage;
			}
		//查询
		@RequestMapping("/Queryinfo")
		@ResponseBody
		public BackMessage StockQuery(HttpServletRequest req, HttpServletResponse res) {
			BackMessage backMessage =null;
			backMessage = service.StockQuery(req, res);
			return backMessage;
			}
}
