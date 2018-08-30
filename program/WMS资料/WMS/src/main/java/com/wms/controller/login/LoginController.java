package com.wms.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.model.CommonDate;
import com.wms.model.MessageDefined;
import com.wms.service.login.LoginService;




@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * 登录验证
	 * @param req
	 * @param res
	 * @param defined
	 * @param session
	 * @param date
	 * @need usercode,password
	 * @return
	 */
	@RequestMapping("goIndex")
	@ResponseBody
	public BackMessage login(HttpServletRequest req,HttpServletResponse res,MessageDefined defined,
			HttpSession session
			,CommonDate date){
		try {
			BackMessage backMessage =loginService.login(req,res,defined,session,date);
			return backMessage;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1, defined.LOGIN_UNEXPECTED_ERROR);
		}
	}
	
	
	/*获取用户权限列表*/
	@RequestMapping(value="/getqueryMenu")
	@ResponseBody
	public BackMessage getqueryMenu(HttpServletRequest req,HttpServletResponse res){
		BackMessage backMessage;
		
		backMessage = loginService.getqueryMenu(req,res);
		return backMessage;
	}
	
	

	/**
	 * 跳转到页面
	 */
	/*@RequestMapping("/redirect")
	public String redirect(HttpServletRequest req) {
		return "index";
	}*/
	
	
	/**
	 * 注册
	 */
	@RequestMapping("/goRegister")
	@ResponseBody
	public BackMessage goRegister(HttpServletRequest req,HttpServletResponse res,MessageDefined defined,
			HttpSession session
			,CommonDate date){
		try {
			BackMessage backMessage =loginService.goRegister(req,res,defined);
			return backMessage;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1, defined.REGISTER_ERROR);
		}
		
	}
	
}
