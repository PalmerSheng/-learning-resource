package com.wms.mapper.systemsetting;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wms.model.UserInfo;

public interface UserMangerMapper {

	public List<UserInfo> selUser(
			@Param("username")String username,
			@Param("usercode")String usercode);
	public boolean delUser(String usercode);
	public boolean updateUserInfo(UserInfo userInfo);
	
}
