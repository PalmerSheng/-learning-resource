package com.wms.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;




public class DynamicDataSource extends AbstractRoutingDataSource {
	
	@Override
	protected Object determineCurrentLookupKey() {
		//获得上下文环境并直接返回
		return DataSourceContextHolder.getDbType();
	}
}