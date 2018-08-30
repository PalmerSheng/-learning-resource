package com.wms.common;

public class DataSourceContextHolder {

	//使用的时候调用 DbContextHolder.setDbType 方法,
	//传入相应的在 spring 配置文件里面的配置的数据源名称就可以了
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setDbType(String dbType) {
		contextHolder.set(dbType);
	}

	public static String getDbType() {
		return ((String) contextHolder.get());
	}

	public static void clearDbType() {
		contextHolder.remove();
	}
}
