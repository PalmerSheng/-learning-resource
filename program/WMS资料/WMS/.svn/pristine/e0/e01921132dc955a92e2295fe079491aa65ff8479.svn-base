package com.wms.mapper.login;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wms.model.UserInfo;


public interface LoginMapper {
	public UserInfo getUser(@Param("usercode")String usercode);
//	public boolean updateUser(UserInfo userInfo);
	public boolean addUser(UserInfo userinfo);
	
	List<Object> getqueryMenu(@Param("level")String level);
}
