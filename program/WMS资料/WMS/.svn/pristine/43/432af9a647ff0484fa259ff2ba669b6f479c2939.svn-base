package com.wms.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Service;

import com.alibaba.druid.pool.DruidDataSource;
import com.wms.common.BackMessage;
import com.wms.common.DataSourceContextHolder;
import com.wms.common.DynamicDataSource;
import com.wms.mapper.storemanagement.DataBaseMapper;
import com.wms.model.DataBase;
import com.wms.service.storemanagement.DataBaseService;
import com.wms.serviceimpl.storemanagement.DataBaseServiceImpl;

public class ChooseDataSourse extends AbstractRoutingDataSource {

	@Autowired
	private ChooseDB chooseDB;
	
	private static Map<Object, Object> target_DataSources;

	
	public static Map<Object, Object> getTarget_DataSources() {
		return target_DataSources;
	}

	////spring注入需要set方法，不是必要的，可以注入也可以不注入
	public static void setTarget_DataSources(Map<Object, Object> target_DataSources) {
		ChooseDataSourse.target_DataSources = target_DataSources;
	}
	
	//对数据源的初始化方法，由于这里已经将数据源集合放在本类中，如果不重写将会由于父类参数为null而抛出异常。
	public void afterPropertiesSet() {}

	///抽象方法，必须重写，用来判断使用哪个数据源
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DataSourceContextHolder.getDbType();
	}

	//确定唯一数据源
	public static boolean checkDB(String key) {
		if (target_DataSources.get(key)!=null) {
			return true;
		}
		return false;
	}
	
	 /**
     * 确定使用哪一个数据源
     * 这里不做null判断，因为是经过null判断后再进入的。
     */
	protected DataSource determineTargetDataSource(){
		
		Object key = determineCurrentLookupKey();
		DataSource dataSource = (DataSource) target_DataSources.get(key);
		return dataSource;
		//return null;
	}
	
	//封装数据源
	public DataSource creatDruidDataSource(DataBase dataBase) {
		
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		druidDataSource.setUsername(dataBase.getUser_name());
		druidDataSource.setPassword(dataBase.getPass_word());
		druidDataSource.setUrl(dataBase.getUrlFull());
		
		return druidDataSource;
	}
	
	//添加数据源
	public synchronized String addDataSourse(DataBase dataBase) {
		if(chooseDB.selDB(dataBase)){
			target_DataSources.put(dataBase.getDb_name(), dataBase);
			return dataBase.getDb_name();
		}
		return dataBase.getDb_name();
	}
}
