package com.wms.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.mapper.storemanagement.DataBaseMapper;
import com.wms.model.DataBase;
@Service
public class ChooseDB {

	@Autowired
	private DataBaseMapper mapper;
	
	public boolean selDB(DataBase dataBase) {
		
		String db_name = dataBase.getDb_name();
		List<DataBase> list = mapper.dataBaseList(db_name);
		if(list.size()==0){
			return true;
		}
		return false;
	}
	
	public List<DataBase> showDB(String db_name) {
		
		//String db_name = dataBase.getDb_name();
		List<DataBase> list = mapper.dataBaseList(db_name);
		return list;
	}
	
}
