package com.wms.service.query;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.common.BackMessage;

public interface InOutRecordsService {
	//加载表
		BackMessage GetInOutRecords(HttpServletRequest req, HttpServletResponse res);
}
