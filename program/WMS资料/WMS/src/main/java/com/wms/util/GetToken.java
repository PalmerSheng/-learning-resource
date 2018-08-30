package com.wms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.UserInfo;


public class GetToken {
	public static UserInfo TokenValue(HttpServletRequest req,HttpServletResponse res){
		
		String token =req.getParameter("token");
		UserInfo info = JWT.unsign(token, UserInfo.class);
		
		return info;
	}
}
