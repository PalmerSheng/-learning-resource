package com.wms.service.storemanagement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.common.BackMessage;

public interface OnOrOutStoreService {

	public BackMessage onStore(HttpServletRequest req, HttpServletResponse res);
	public BackMessage onStore01(HttpServletRequest req, HttpServletResponse res);

	public BackMessage outStore(HttpServletRequest req, HttpServletResponse res);
	public BackMessage outStore01(HttpServletRequest req, HttpServletResponse res);

}
