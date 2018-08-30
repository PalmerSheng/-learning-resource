package com.wms.controller.systemsetting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wms.common.BackMessage;
import com.wms.service.systemsetting.PwdModifiedService;
@Controller
@RequestMapping("PwdModifiedController")
public class PwdModifiedController {

	@Autowired
	private PwdModifiedService pwdModifiedService;
	
	
	/**
	 * 修改密码
	 * @param req oldPassword,newPassword,checkPassword
	 * @return
	 */
	@RequestMapping("pwdModified")
	@ResponseBody
	public BackMessage pwdModified(HttpServletRequest req,HttpServletResponse res){
		BackMessage backMessage =null;
		backMessage = pwdModifiedService.pwdModified(req,res);
		System.out.println(backMessage);
		return backMessage;

	}
	
	
	
		
}
