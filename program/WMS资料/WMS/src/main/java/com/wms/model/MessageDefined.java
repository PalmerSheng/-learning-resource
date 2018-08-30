package com.wms.model;

public class MessageDefined {
	
	public String LOGIN_USER_NULL = "用户名或密码不能为空";
	public String LOGIN_USERID_ERROR = "用户不存在!";
    public String LOGIN_PASSWORD_ERROR = "密码错误!";
    public String LOGIN_USERID_DISABLED = "账号已被禁用!";
    public String LOGIN_NO_LOGED = "未登录!";
    public String LOGIN_SUCCESS = "登录成功!";
    public String LOGOUT_SUCCESS = "注销成功!";
    
    public String REG_USERID_ERROR = "用戶名已存在";
    
    public String REG_PASSWORD_ERROR = "两次密码不一致";
    
    public String LOGIN_LASTTIME_ERROR = "更新上次登录状态失败";
    
    public String LOGIN_UNEXPECTED_ERROR = "发生意外错误";
	

	public String VERTIFYCODE_ERROR = "验证码错误";	

    public String LOG_TYPE_COMPLETE = "完成";
    public String LOG_TYPE_IMPORT = "导入";
    public String LOG_TYPE_EXPORT = "导出";
    public String LOG_TYPE_DEPLOY = "部署";
    public String LOG_TYPE_START = "启动";

    public String LOG_DETAIL_USER_LOGIN = "用户登陆";
    public String LOG_DETAIL_USER_LOGOUT = "用户退出";
    public String LOG_DETAIL_UPDATE_PROFILE = "更新用户资料";
    public String LOG_DETAIL_UPDATE_PROFILEHEAD = "更新用户头像";
    public String LOG_DETAIL_SYSCONFIG = "系统设置";
    public String LOG_DETAIL_UPDATE_PASSWORD = "更新密码";
    
    public String REG_SUCCESS = "注册成功";
    public String REG_UNEXPECTED_ERROR = "注册发生未知异常";
    public String REGISTER_ERROR = "注册时发生错误";
    public String REGISTER_USERID_EXIST = "该用户名已存在";
    public String REGISTER_PASSWORD_DIFFERENT = "两次密码不一致";
    public String REGISTER_ADDUSER_ERROR = "添加用户失败";
    public String PRAGRAM_EXCEPTION	= "系统异常";
    
    public String DELETE_FAIL = "删除失败";
    public String DELETE_SUCCESS = "删除失败";
    
    public String CREATE_USER_SUCCESS = "添加用户成功";
    public String CREATE_USER_FAIL= "添加用户失败";
    
    /*
     * 修改密码
     */
    public String MODIFY_PWD_NULL = "原密码不能为空";
    public String MODIFY_NEWPWD_NULL = "新密码不能为空";
    public String MODIFY_NEWPWD_DIFFERENT = "两次密码不一致";
    public String MODIFY_FAILED = "修改失败";
    
}
