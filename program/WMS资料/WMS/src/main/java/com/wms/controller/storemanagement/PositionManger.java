package com.wms.controller.storemanagement;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.model.Posit;
import com.wms.service.storemanagement.OnOrOutStoreService;

@Controller
@SuppressWarnings("all")
@RequestMapping("PositionManger")
public class PositionManger {

	@Autowired
	private OnOrOutStoreService service;

	@RequestMapping(value = "/show")
	@ResponseBody
	public BackMessage show(HttpServletRequest req, HttpServletResponse res) {

		//BackMessage backMessage = service.show(req, res);
		List<Posit> list = new ArrayList<Posit>();
		
		for(int i=1;i<10;i++){
			Posit posit = new Posit();
			posit.setId(i);
			//posit.setHandle(handle);
			posit.setPhone(i+"库");
			posit.setSex("1区");
			posit.setSupplierName("货位"+i);
			list.add(posit);
		}
		
		return new BackMessage(0, null, list);
	}
	
}
