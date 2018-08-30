package com.wms.mapper.storemanagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;

import com.wms.common.BackMessage;
import com.wms.model.DataBase;

public interface DataBaseMapper {

	public List<DataBase> dataBaseList(
			@Param("db_name")String db_name);
	
}
