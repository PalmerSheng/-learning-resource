package com.wms.serviceimpl.query;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.common.BackMessage;
import com.wms.mapper.query.InOutRecordsMapper;
import com.wms.mapper.query.StockQueryMapper;
import com.wms.model.GoodsModel;
import com.wms.model.InOutRecordsModel;
import com.wms.service.query.InOutRecordsService;
@Service
public class InOutRecordsImpl implements InOutRecordsService {
	@Autowired
	private  InOutRecordsMapper mapper;
	//将list<?>变成<list<object>格式
			static public <E> List<Object> toObject(List<E> list){
				List<Object> objlist = new ArrayList<Object>();
				for(Object e : list){
					Object obj = (Object)e;
					objlist.add(obj);
				}
				return objlist;
			}
	
	public BackMessage GetInOutRecords(HttpServletRequest req, HttpServletResponse res) {
		BackMessage backMessage=null;
		String startTime=(req.getParameter("startTime")==null?"":
			req.getParameter("startTime").trim());
		String time=(req.getParameter("time")==null?"":
			req.getParameter("time").trim());
	
		
		String endTime=(req.getParameter("endTime")==null?"":
			req.getParameter("endTime").trim());
		System.out.println("startTime"+startTime);
		System.out.println("end:"+endTime);
		/*startTime = "2018-05-04";
		endTime = "2018-05-07";*/
		List<InOutRecordsModel> list=mapper.GetInOutRecords(startTime, endTime);
		List<Object> objList = toObject(list);
		
		backMessage=new BackMessage(0, "ok", objList.size(), objList);
		return backMessage;
	}

}
