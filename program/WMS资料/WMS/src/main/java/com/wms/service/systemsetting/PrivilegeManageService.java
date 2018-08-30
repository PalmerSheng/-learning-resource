package com.wms.service.systemsetting;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wms.common.BackMessage;
import com.wms.model.LoginLeftBar;

public interface PrivilegeManageService {
	public List<Object> getPrivilege(HttpServletRequest req);
	public int UpdateUserPrivilege(String level,String treelevels);
}
