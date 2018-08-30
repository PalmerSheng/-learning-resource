package com.sf.util;

import java.io.IOException;    

import javax.servlet.ServletException;    
import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;    
import javax.servlet.http.HttpSession;    
  
/**
 * 
 * @author : sf
 * @time   : 2018年7月29日  上午7:57:53 
 * @TODO   :
 */
public class AuthImage extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {    
    static final long serialVersionUID = 1L;    
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        response.setHeader("Pragma", "No-cache");    
        response.setHeader("Cache-Control", "no-cache");    
        response.setDateHeader("Expires", 0);    
        response.setContentType("image/jpeg");    
            
        //生成随机字串    
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);    
        //存入会话session    
        HttpSession session = request.getSession();  
        String code = verifyCode.toLowerCase();
        session.setAttribute("vertifycode",code );  
        //生成图片    
        int w = 200, h = 80;    
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);    
    
    }    
}    


/*
 * 
<servlet>    
	<servlet-name>AuthImage</servlet-name>    
	<servlet-class>com.sf.util.AuthImage</servlet-class>    
</servlet>    
<servlet-mapping>    
	<servlet-name>AuthImage</servlet-name>    
	<url-pattern>/authImage</url-pattern>    
</servlet-mapping>*/