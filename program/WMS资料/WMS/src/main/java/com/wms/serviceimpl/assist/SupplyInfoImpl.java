package com.wms.serviceimpl.assist;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.common.BackMessage;
import com.wms.mapper.assist.SupplyInfoMapper;
import com.wms.model.SupplyInfoModel;
import com.wms.service.assist.SupplyInfoService;
@Service
public class SupplyInfoImpl implements SupplyInfoService {
	@Autowired
	private  SupplyInfoMapper mapper;
	//将list<?>变成<list<object>格式
	static public <E> List<Object> toObject(List<E> list){
		List<Object> objlist = new ArrayList<Object>();
		for(Object e : list){
			Object obj = (Object)e;
			objlist.add(obj);
		}
		return objlist;
	}

	

	//更新数据
	public BackMessage UpdateSupplyInfo(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
			String supply_name=(req.getParameter("supply_name")==null?"":
				req.getParameter("supply_name").trim());
			String supply_code=(req.getParameter("supply_code")==null?"":
				req.getParameter("supply_code").trim());
			String tel=(req.getParameter("tel")==null?"":
				req.getParameter("tel").trim());
			String duty_name=(req.getParameter("duty_name")==null?"":
				req.getParameter("duty_name").trim());
			
			try {
				mapper.UpdateSupplyInfo(supply_name, supply_code, duty_name, tel);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
				//return new BackMessage(1001, "修改信息出错", -1, null);
			}
			
			return new BackMessage(0, "新增信息成功", -1, null);
			
		
	}

	//插入数据
	public BackMessage InsertSupplyInfo(HttpServletRequest req, HttpServletResponse res) {
		String supply_name=(req.getParameter("supply_name")==null?"":
			req.getParameter("supply_name").trim());
		String supply_code=(req.getParameter("supply_code")==null?"":
			req.getParameter("supply_code").trim());
		String tel=(req.getParameter("tel")==null?"":
			req.getParameter("tel").trim());
		String duty_name=(req.getParameter("duty_name")==null?"":
			req.getParameter("duty_name").trim());
		try {
			mapper.InsertSupplyInfo(supply_name, supply_code, duty_name, tel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());

		}
		return new BackMessage(0, "新增信息成功", -1, null);
	}

	//删除数据
	public BackMessage DeleteSupplyInfo(HttpServletRequest req, HttpServletResponse res) {
		
		BackMessage backMessage = new BackMessage(0, "success");
		try {
			String supply_code = (req.getParameter("supply_code") == null ? "" :(req.getParameter("supply_code").trim()));
			
			mapper.DeleteSupplyInfo(supply_code);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return backMessage;
	}

	//查询数据
	public BackMessage Info(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String supply_name = (req.getParameter("supply_name") == null ? "" :(req.getParameter("supply_name").trim()));
		String supply_code = (req.getParameter("supply_code") == null ? "" :(req.getParameter("supply_code").trim()));
		BackMessage backMessage=null;
		List<SupplyInfoModel> list=mapper.Info(supply_name, supply_code);
		List<Object> objList = toObject(list);

		backMessage=new BackMessage(0, "ok", objList.size(), objList);
		return backMessage;
	}

}
