package com.wms.service.systemsetting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.common.BackMessage;

public interface PwdModifiedService {
	public BackMessage pwdModified(HttpServletRequest req,HttpServletResponse res);
}
