package com.wms.util;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import com.wms.common.BackMessage;
import com.wms.model.UserInfo;



public class UrlInterceptor implements HandlerInterceptor{
	
	
	 public void afterCompletion(HttpServletRequest request,
	            HttpServletResponse response, Object handler, Exception arg3)
	            throws Exception {
	    }

	    public void postHandle(HttpServletRequest request, HttpServletResponse response,
	            Object handler, ModelAndView model) throws Exception {
	    	//String aString = request.getHeader("");
	    }

	    //拦截每个请求
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
	            Object handler) throws Exception {
	    	
	        response.setCharacterEncoding("utf-8");
	        response.setHeader("Access-Control-Allow-Origin", "*");
	        /*String token = request.getParameter("token").trim();
	        BackMessage backMessage = null;
	        //token不存在
	        UserInfo info = GetToken.TokenValue(request, response);
	        if(info==null){
	        	responseMessage(response, response.getWriter());
	        	return false;
	        }*/
	        return true;
	        
	    	
	    }

	      
	    //请求不通过，返回错误信息给客户端
	    private void responseMessage(HttpServletResponse response,
	    		PrintWriter out) {
	    	
	    	response.setContentType("application/json; charset=utf-8"); 
	        
	        out.print("用户身份已过期，请重新登录");
	        out.flush();
	        out.close();
	    }

	
}
