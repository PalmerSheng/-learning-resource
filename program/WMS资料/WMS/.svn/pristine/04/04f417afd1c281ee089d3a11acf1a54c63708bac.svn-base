package com.wms.controller.assist;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.service.assist.StoreKeeperService;


@Controller
@RequestMapping("StoreKeeperInfoController")
public class StoreKeeperController {
	@Autowired
	private  StoreKeeperService service;
	
	//新增部门信息
	@RequestMapping("/insertinfo")
	@ResponseBody
	public BackMessage InsertStoreKeeperInfotwo(HttpServletRequest req, HttpServletResponse res) {
		BackMessage backMessage =null;
		//backMessage = service.InsertStoreKeeperInfotwo(req, res);
		backMessage = service.InsertStoreKeeperInfo(req, res);
		return backMessage;
		}
	/*public BackMessage InsertStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
		BackMessage backMessage =null;
		backMessage = service.InsertStoreKeeperInfo(req, res);
		return backMessage;
		}*/
	
	//修改管理员信息
	@RequestMapping("/updateinfo")
	@ResponseBody
	public BackMessage UpdateStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
		BackMessage backMessage =null;
		backMessage = service.UpdateStoreKeeperInfo(req, res);
		return backMessage;
		}
	
	//删除管理员信息
	@RequestMapping("/deleteinfo")
	@ResponseBody
	public BackMessage DeleteStoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
		BackMessage backMessage =null;
		service.DeleteStoreKeeperInfo(req, res);
		backMessage = service.DeleteStoreKeeperInfo(req, res);
		return backMessage;
		}
	
	//查询
	@RequestMapping("/info")
	@ResponseBody
	public BackMessage StoreKeeperInfo(HttpServletRequest req, HttpServletResponse res) {
		BackMessage backMessage =null;
		backMessage = service.StoreKeeperInfo(req, res);
		return backMessage;
		}

}
