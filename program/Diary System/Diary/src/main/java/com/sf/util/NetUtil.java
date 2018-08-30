package com.sf.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author : sf
 * @time   : 2018年7月29日  上午7:25:41 
 * @TODO   : 网络工具类
 */
public class NetUtil {

	/**
	 * 从request中获取ip地址
	 * @param request
	 * @return
	 */
    public String getIpAddress(HttpServletRequest request) {
    	String ip = request.getHeader("x-forwarded-for"); 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
          ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
          ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
          ip = request.getHeader("HTTP_CLIENT_IP"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
          ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
        } 
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
          ip = request.getRemoteAddr(); 
        }  
        return ip; 
    }
}
