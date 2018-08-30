package com.wms.service.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wms.common.BackMessage;
import com.wms.model.CommonDate;
import com.wms.model.MessageDefined;

public interface LoginService {
	public BackMessage login(HttpServletRequest req,HttpServletResponse res,MessageDefined defined,
			HttpSession session
			,CommonDate date);
	
	public BackMessage goRegister(HttpServletRequest req,HttpServletResponse res,MessageDefined defined);
	
	public BackMessage getqueryMenu(HttpServletRequest req,HttpServletResponse res);
}
