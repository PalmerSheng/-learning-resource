package com.wms.service.query;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.common.BackMessage;

public interface StockQueryService {
	//加载表
	BackMessage GetStockInfo(HttpServletRequest req, HttpServletResponse res);
	//库存查询
	BackMessage StockQuery(HttpServletRequest req, HttpServletResponse res);
}
