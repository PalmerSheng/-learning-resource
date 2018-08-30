package com.wxl.commons;

import org.apache.log4j.Logger;

/**
 * 自定义的异常类
 * @author zhu
 *
 */
public class NormalException extends Exception 
{
	 //接口日志记录工具
    private Logger LOGGER = Logger.getLogger(NormalException.class);
    
	//重载的构造函数
	public NormalException()
	{
        super();
    }
	
	//重载的构造函数
	public NormalException(String msg)
	{
        super(msg);
    }
    
	//重载的构造函数
    public NormalException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
    //重载的构造函数
    public NormalException(Throwable cause)
    {
        super(cause);
    }
    
    @Override
    public void printStackTrace() 
    {
    	super.printStackTrace();
    	
    	//输出Log日志
    	LOGGER.error(getMessage() + "详细信息 :" + fillInStackTrace());
    }
}
