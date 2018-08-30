package com.wms.mapper.systemsetting;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface PrivilegeManageMapper {
	public List<Object> getPrivilege(String level);
public int DeletePrivileges(@Param("level")String level);
	
	public int AddPrivileges(Map<String, Object> map);
}
