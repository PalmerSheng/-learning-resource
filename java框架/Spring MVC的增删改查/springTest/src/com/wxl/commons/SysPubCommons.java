package com.wxl.commons;




/**
 * 系统公共的工具类 用于统一的日志输出 以及统一的Json格式封装等功能
 * @author zhu
 *
 */
public class SysPubCommons {
	   /**
     * 定义公共的对象Json格式(重载函数)
     * @param strStatus
     * @param strMsg
     * @param strNormal
     * @return
     */
	public static PubResJsonObj GetJsonObj(String strStatus,String strMsg)
    {
    	PubResJsonObj jsonObj = new PubResJsonObj();
    	
    	jsonObj.setResult(strStatus);
    	jsonObj.setMsg(strMsg);
    	
    	return jsonObj;
    }
	
}
