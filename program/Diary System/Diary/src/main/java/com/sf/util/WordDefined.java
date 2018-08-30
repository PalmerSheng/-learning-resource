package com.sf.util;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

/**
 * 
 * @author : sf
 * @time   : 2018年7月29日  上午8:46:27 
 * @TODO   : 定义
 */
public class WordDefined {
	/**
	 * 登录 注销
	 */
    public String LOGIN_USERID_ERROR = "用户名不存在!";
    public String LOGIN_PASSWORD_ERROR = "密码错误!";
    public String LOGIN_USERID_DISABLED = "账号已被禁用!";
    public String LOGIN_NO_LOGED = "未登录!";
    public String LOGIN_SUCCESS = "登录成功!";
    public String LOGOUT_SUCCESS = "注销成功!";
    public String LOGIN_UNEXPECTED_ERROR = "发生意外错误";
    public String LOGIN_VERTIFYCODE_ERROR = "验证码错误"; 
    public String LOGIN_LASTTIME_ERROR = "更新登陆时间失败";
    public String LOGIN_USERID_EMPTY = "用户名不能为空";
    public String LOGIN_PASSWORD_EMPTY = "密码不能为空";
    public String LOGIN_CODE_EMPTY = "验证码不能为空";
    public String LOGIN_CODE_INCORRECT = "验证码错误，请重试";

    
    /**
     * 注册
     */
    
    public String REG_USERID_ERROR = "用戶名已存在";
    public String REG_PASSWORD_ERROR = "两次密码不一致";
    public String REG_SUCCESS = "注册成功";
    public String REG_ERROR = "注册出现异常";
	public String REG_ADDUSER_ERROR = "添加用户失败";
	public String REG_USERID_EMPTY = "用户名不能为空";
	public String REG_PASSWORD_EMPTY = "密码不能为空";
	public String REG_CHECKPASSWORD_EMPTY = "确认密码不能为空";
	public String REG_NICKNAME_EMPTY = "昵称不能为空";


	/**
	 * 系统日志
	 */

    public String LOG_TYPE_LOGIN = "登陆";
    public String LOG_TYPE_REG = "注册";
    public String LOG_TYPE_LOGOUT = "注销";
    public String LOG_TYPE_ADD = "新增";
    public String LOG_TYPE_UPDATE = "更新";
    public String LOG_TYPE_DELETE = "删除";
    public String LOG_TYPE_COMPLETE = "完成";
    public String LOG_TYPE_IMPORT = "导入";
    public String LOG_TYPE_EXPORT = "导出";
    public String LOG_TYPE_DEPLOY = "部署";
    public String LOG_TYPE_START = "启动";

    public String LOG_DETAIL_USER_LOGIN = "用户登陆";
    public String LOG_DETAIL_USER_REG = "用户注册";
    public String LOG_DETAIL_USER_LOGOUT = "用户退出";
    public String LOG_DETAIL_UPDATE_PROFILE = "更新用户资料";
    public String LOG_DETAIL_UPDATE_PROFILEHEAD = "更新用户头像";
    public String LOG_DETAIL_SYSCONFIG = "系统设置";
    public String LOG_DETAIL_UPDATE_PASSWORD = "更新密码";
    
    /**
     * 日记
     */
    public String DIARY_INSERT_SUCCESS = "日志保存成功";
    public String DIARY_INSERT_FAIL = "日志保存失败";
    public String DIARY_INSERT_ERROR = "日志保存发生异常";
    public String DIARY_UPDATE_SUCCESS = "日志更新成功";
    public String DIARY_UPDATE_FAIL = "日志更新失败";
    public String DIARY_UPDATE_ERROR = "日志更新发生异常";
    
    
}
