package com.wms.serviceimpl.storemanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.common.BackMessage;
import com.wms.mapper.storemanagement.SumStoreMapper;
import com.wms.model.BackOrTakeModel;
import com.wms.service.storemanagement.SumStoreService;

@Service
@SuppressWarnings("all")
public class SumStoreServiceImpl implements SumStoreService {

	@Autowired
	private SumStoreMapper mapper;
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 可以方便地修改日期格式

	public BackMessage sumStore(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		List<BackOrTakeModel> list = mapper.sumStore();
		//System.out.println("dasjhdjashjkd?>>>>>>>>>>");
		return new BackMessage(0, "成功", list);
	}

}
