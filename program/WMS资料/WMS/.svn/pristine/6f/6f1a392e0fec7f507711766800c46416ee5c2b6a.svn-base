package com.wms.controller.query;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.service.query.InOutRecordsService;

@Controller
@SuppressWarnings("all")
@RequestMapping("InOutRecordsController")
public class InOutRecordsController {
	@Autowired
    private InOutRecordsService service;
	//加载表
			@RequestMapping("/InOutRecordsInit")
			@ResponseBody
				public BackMessage GetInOutRecords(HttpServletRequest req, HttpServletResponse res) {
				BackMessage backMessage =null;
				backMessage = service.GetInOutRecords(req, res);
				return backMessage;
				}

}
