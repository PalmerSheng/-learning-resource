package com.wms.controller.systemsetting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.model.MessageDefined;
import com.wms.service.login.LoginService;
import com.wms.service.systemsetting.UserMangerService;

/**
 * 用户管理
 * @author sf
 *
 */
@Controller
@RequestMapping("userManageController")
public class UserManageController {

	@Autowired
	private UserMangerService service;
	@Autowired
	private LoginService loginService;

	
	@RequestMapping(value = "selUser")
	@ResponseBody
	public BackMessage selUser(HttpServletRequest req, HttpServletResponse res) {

		BackMessage backMessage = service.selUser(req, res);
		return backMessage;
	}

	@RequestMapping("delUser")
	@ResponseBody
	public BackMessage delUser(HttpServletRequest req, HttpServletResponse res){
		BackMessage backMessage = service.delUser(req,res);
		return backMessage;
	}

	@RequestMapping("addUser")
	@ResponseBody
	public BackMessage addUser(HttpServletRequest req, HttpServletResponse res){
		MessageDefined defined = new MessageDefined();
		BackMessage backMessage = loginService.goRegister(req,res,defined);
		return backMessage;
	}


	@ResponseBody
	@RequestMapping("updateUserInfo")
	public BackMessage updateUserInfo(HttpServletRequest req,HttpServletResponse res,MessageDefined defined){
		try {
			return service.updateUserInfo(req,res,defined);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1, defined.PRAGRAM_EXCEPTION);
		}
	}
}

