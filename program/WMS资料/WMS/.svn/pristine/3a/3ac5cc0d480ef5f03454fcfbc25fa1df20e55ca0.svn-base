package com.wms.serviceimpl.storemanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.common.BackMessage;
import com.wms.mapper.storemanagement.DataBaseMapper;
import com.wms.model.DataBase;
import com.wms.service.storemanagement.DataBaseService;

@Service
@SuppressWarnings("all")
public class DataBaseServiceImpl implements DataBaseService {

	@Autowired
	private DataBaseMapper mapper;
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 可以方便地修改日期格式

	public BackMessage dataBaseList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		List<DataBase> list = mapper.dataBaseList(null);
		return new BackMessage(0, null, list);
	}

}
