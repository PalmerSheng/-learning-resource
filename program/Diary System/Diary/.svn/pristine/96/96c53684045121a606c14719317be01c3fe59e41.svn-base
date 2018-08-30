package com.sf.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.sf.common.DataSourceContextHolder;



public class DynamicDataSource extends AbstractRoutingDataSource {
	
	@Override
	protected Object determineCurrentLookupKey() {
		//获得上下文环境并直接返回
		return DataSourceContextHolder.getDbType();
	}
}