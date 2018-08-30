package com.sf.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sf.model.Log;
import com.sf.model.UserInfo;
import com.sf.service.LogService;
import com.sf.util.CusAccessObjectUtil;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;





//让这个切面类被Spring所管理
@Component("SystemLogAspect")
// 声明这是一个切面类
@Aspect
public class SystemLogAspect{
	//注入Service用于把日志保存数据库
	@Resource
	private LogService logService;

	private static final Logger logger = Logger.getLogger(SystemLogAspect.class);
	//private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SystemLogAspect.class);



	//Controller层切点
	@Pointcut("@annotation(com.sf.common.SystemControllerLog)")
	public void controllerAspect(){

	}


	//Service层切点
	@Pointcut("@annotation(com.sf.common.SystemServiceLog)")
	public void serviceAspect(){

	}

	/**
	 * 前置通知 用于拦截Controller层记录用户的操作
	 * 
	 * @param joinPoint 切点
	 * @throws UnknownHostException 
	 */
	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) throws UnknownHostException {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		//读取session中的用户  
		UserInfo userInfo = (UserInfo)session.getAttribute("loginuser");
		if(userInfo==null) return;
		//请求的IP 
		/*		 InetAddress addr = InetAddress.getLocalHost();
		 String ip = addr.getHostAddress().toString();*/
		String ip=CusAccessObjectUtil.getIpAddress(request);
		if("0:0:0:0:0:0:0:1".equals(ip)){
			//这个ip代表为本机的ip
			InetAddress addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress().toString(); 
		}
		try {    
			//*========控制台输出=========*//    
			/*	            System.out.println("=====前置通知开始=====");    
	            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
	            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
	            System.out.println("请求人:" + objLogin.getUsercode());
	            System.out.println("请求IP:" + ip); 
	            System.out.println("请求时间"+new Date());*/
			/*System.out.println("班级:" + objLogin.getClasscode());
	            System.out.println("专业:" + objLogin.getMojarcode());
	            System.out.println("学院:" + objLogin.getSchoolcode());*/
			//*========数据库日志=========*//    
			Log log = new Log();    
			log.setUserid(userInfo.getUserid());
			log.setIp(ip);
			String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			log.setTime(time);
			log.setDetail(getControllerMethodDescription(joinPoint));
			//保存数据库    
			logService.insert(log);
			//System.out.println("=====前置通知结束=====");    
		}  catch (Exception e) {    
			//记录本地异常日志    
			logger.error("==前置通知异常==");    
			logger.error("异常信息:", e);  
		}    
	}

	/**  
	 * 异常通知 用于拦截service层记录异常日志  
	 *  
	 * @param joinPoint  
	 * @param e  
	 * @throws UnknownHostException 
	 */    
	@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")    
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) throws UnknownHostException {    
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
		HttpSession session = request.getSession();    
		//读取session中的用户    
		UserInfo  objLogin = (UserInfo)session.getAttribute("loginuser");    
		//获取请求ip    
		InetAddress addr = InetAddress.getLocalHost();
		String ip = addr.getHostAddress().toString();   
		try {    
			/*========控制台输出=========*/    
			System.out.println("=====异常通知开始=====");    
			System.out.println("异常代码:" + e.getClass().getName());    
			System.out.println("异常信息:" + e.getMessage());    
			System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
			System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));    
			System.out.println("请求人id:" + objLogin.getUserid());
			System.out.println("请求IP:" + ip);    


			//            SystemOprationLog log = new SystemOprationLog();    
			//            log.setUserid(objLogin.getUserid());
			//            log.setStationid(objLogin.getStationid());
			//            log.setDeptid(objLogin.getDeptid());
			//            log.setCompanyid(objLogin.getCompanyid());
			//            log.setSysoprip(ip);
			//            log.setSysoprtime(new Date());
			//            log.setSysoprtext(getControllerMethodDescription(joinPoint));
			//            //保存数据库    
			//            systemOprationLogService.insertSystemOprationLog(log);    
			System.out.println("=====异常通知结束=====");    
		}  catch (Exception ex) {    
			//记录本地异常日志    
			logger.error("==异常通知异常==");    
			logger.error("异常信息:", ex);    
		}    
	}    


	/**  
	 * 获取注解中对方法的描述信息 用于service层注解  
	 *  
	 * @param joinPoint 切点  
	 * @return 方法描述  
	 * @throws Exception  
	 */    
	public static String getServiceMthodDescription(JoinPoint joinPoint)    
			throws Exception {    
		String targetName = joinPoint.getTarget().getClass().getName();    
		String methodName = joinPoint.getSignature().getName();    
		Object[] arguments = joinPoint.getArgs();    
		Class targetClass = Class.forName(targetName);    
		Method[] methods = targetClass.getMethods();    
		String description = "";    
		for (Method method : methods) {    
			if (method.getName().equals(methodName)) {    
				Class[] clazzs = method.getParameterTypes();    
				if (clazzs.length == arguments.length) {    
					description = method.getAnnotation(SystemServiceLog.class).value();    
					break;    
				}    
			}    
		}    
		return description;    
	}    

	/**  
	 * 获取注解中对方法的描述信息 用于Controller层注解  
	 *  
	 * @param joinPoint 切点  
	 * @return 方法描述  
	 * @throws Exception  
	 */    
	public static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
		String targetName = joinPoint.getTarget().getClass().getName();    
		String methodName = joinPoint.getSignature().getName();    
		Object[] arguments = joinPoint.getArgs();    
		Class targetClass = Class.forName(targetName);    
		Method[] methods = targetClass.getMethods();    
		String description = "";    
		for (Method method : methods) {    
			if (method.getName().equals(methodName)) {    
				Class[] clazzs = method.getParameterTypes();    
				if (clazzs.length == arguments.length) {    
					description = method.getAnnotation(SystemControllerLog.class).value();    
					break;    
				}    
			}    
		}    
		return description;    
	}    

}
