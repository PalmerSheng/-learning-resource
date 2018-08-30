package com.wms.serviceimpl.query;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.common.BackMessage;
import com.wms.mapper.query.StockQueryMapper;
import com.wms.model.GoodsModel;
import com.wms.model.InOutRecordsModel;
import com.wms.service.query.StockQueryService;
@Service
public class StockQueryImpl implements StockQueryService {
	@Autowired
	private  StockQueryMapper mapper;
	//将list<?>变成<list<object>格式
			static public <E> List<Object> toObject(List<E> list){
				List<Object> objlist = new ArrayList<Object>();
				for(Object e : list){
					Object obj = (Object)e;
					objlist.add(obj);
				}
				return objlist;
			}
	//加载表
	public BackMessage GetStockInfo(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		BackMessage backMessage=null;
		List<GoodsModel> list=mapper.GetStockInfo();
		List<Object> objList = toObject(list);
		
		backMessage=new BackMessage(0, "ok", objList.size(), objList);
		return backMessage;
	}
	//查询
	public BackMessage StockQuery(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		BackMessage backMessage=null;
		String goods_code=(req.getParameter("goods_code")==null?"":
			req.getParameter("goods_code").trim());
		String goods_name=(req.getParameter("goods_name")==null?"":
			req.getParameter("goods_name").trim());
		List<GoodsModel> list=mapper.StockQuery(goods_code, goods_name);
		List<Object> objList = toObject(list);
		
		backMessage=new BackMessage(0, "ok", objList.size(), objList);
		return backMessage;
	}
}
