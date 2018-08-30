package com.wms.serviceimpl.storemanagement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.wms.common.BackMessage;
import com.wms.mapper.storemanagement.BackOrTakeStoreMapper;
import com.wms.model.BackOrTakeModel;
import com.wms.service.storemanagement.BackOrTakeStoreService;
import com.wms.util.TimeGetNow;

@Service
@SuppressWarnings("all")
public class BackOrTakeStoreImpl implements BackOrTakeStoreService {

	@Autowired
	private BackOrTakeStoreMapper mapper;
	Date now = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");// 可以方便地修改日期格式

	public BackMessage backStore(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub

		/**
		 * json解析  
		 * 
		 * data{ goods:[{id:'',goods_code:'',goods_num:'',
		 * take_code:'',duty_code:'',time:'',take_state:'',state:''}] }
		 * 
		 * id, goods_code ,goods_num, take_code, duty_code, time, take_state, state,
		 * take_state;// 领料状态 0未领 1已领
		 * state;// 进出库状态 0入库 1出库
		 */
		
		List<BackOrTakeModel> list = null;
		String data = req.getParameter("data");
		JSONObject object = JSON.parseObject(data);
		JSONArray jsonArray = object.getJSONArray("goods");
		
		/**
		 * 得到BackOrTakeModel集合
		 */
		list = JSON.parseArray(jsonArray.toJSONString(),
				BackOrTakeModel.class);
		
		try {
			//List<BackOrTakeModel> models = mapper.selGoods(list);
			mapper.backStore01(list, "");
			mapper.backStore02(list, "");
			return new BackMessage(200, "退料成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new BackMessage(1000, "退料失败");
		}
	}

	public BackMessage takeStore(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		/**
		 * json解析  
		 * 
		 * data{ goods:[{id:'',goods_code:'',goods_num:'',
		 * take_code:'',duty_code:'',time:'',take_state:'',state:''}] }
		 * 
		 * id, goods_code ,goods_num, take_code, duty_code, time, take_state, state,
		 * take_state;// 领料状态 0未领 1已领
		 * state;// 进出库状态 0入库 1出库
		 */
		
		List<BackOrTakeModel> list = null;
		String data = req.getParameter("data");
		JSONObject object = JSON.parseObject(data);
		JSONArray jsonArray = object.getJSONArray("goods");
		
		/**
		 * 得到BackOrTakeModel集合
		 */
		list = JSON.parseArray(jsonArray.toJSONString(),
				BackOrTakeModel.class);
		
		try {
			//List<BackOrTakeModel> models = mapper.selGoods(list);
			//mapper.selGoods(goods_code);
			mapper.takeStore01(list, "");
			mapper.takeStore02(list, "");
			return new BackMessage(200, "取料成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new BackMessage(1000, "取料失败");
		}
	}

	private String getStr(String str, HttpServletRequest req) {

		String newStr = req.getParameter(str).trim();
		newStr = (newStr == null) ? "" : newStr;
		return newStr;
	}

	//退货
	public BackMessage backStore01(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		//id, goods_code ,goods_num, take_code, duty_code, time, take_state, state
		String goods_code = (req.getParameter("goods_code") == null ? "" : (req.getParameter("goods_code").trim()));
		String goods_num = (req.getParameter("goods_num") == null ? "" : (req.getParameter("goods_num").trim()));
		String take_code = (req.getParameter("take_code") == null ? "" : (req.getParameter("take_code").trim()));
		String duty_code = (req.getParameter("duty_code") == null ? "" : (req.getParameter("duty_code").trim()));
		String time = TimeGetNow.getTime();//null;//(req.getParameter("time") == null ? "" : (req.getParameter("time").trim()));
		String take_state = (req.getParameter("take_state") == null ? "" : (req.getParameter("take_state").trim()));
		String state = (req.getParameter("state") == null ? "" : (req.getParameter("state").trim()));
		
		List<BackOrTakeModel> list = new ArrayList<BackOrTakeModel>();
		BackOrTakeModel model = new BackOrTakeModel();
		model.setGoods_code(goods_code);
		model.setGoods_num(goods_num);
		model.setTake_code(take_code);
		model.setDuty_code("admin");
		model.setTime(time);
		model.setTake_state("1");
		model.setState("0");
		list.add(model);

		
		try {
			mapper.backStore01(list, time);
			mapper.backStore02(list, time);
			return new BackMessage(200, "退料成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new BackMessage(1000, "退料失败");
		}
	}

	//取货
	public BackMessage takeStore01(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String goods_code = (req.getParameter("goods_code") == null ? "" : (req.getParameter("goods_code").trim()));
		String goods_num = (req.getParameter("goods_num") == null ? "" : (req.getParameter("goods_num").trim()));
		String take_code = (req.getParameter("take_code") == null ? "" : (req.getParameter("take_code").trim()));
		String duty_code = (req.getParameter("duty_code") == null ? "" : (req.getParameter("duty_code").trim()));
		String time = TimeGetNow.getTime();//null;//(req.getParameter("time") == null ? "" : (req.getParameter("time").trim()));
		String take_state = (req.getParameter("take_state") == null ? "" : (req.getParameter("take_state").trim()));
		String state = (req.getParameter("state") == null ? "" : (req.getParameter("state").trim()));
		
		List<BackOrTakeModel> list = new ArrayList<BackOrTakeModel>();
		BackOrTakeModel model = new BackOrTakeModel();
		model.setGoods_code(goods_code);
		model.setGoods_num(goods_num);
		model.setTake_code(take_code);
		model.setDuty_code("admin");
		model.setTime(time);
		model.setTake_state("1");
		model.setState("1");
		list.add(model);

		List<BackOrTakeModel> models = mapper.takeStore03(list, time);
		for (int i = 0; i < models.size(); i++) {
			BackOrTakeModel model2 = models.get(i);
			if (Integer.parseInt(model2.getGoods_num()) < Integer.parseInt(model.getGoods_num())) {
				return new BackMessage(1000, "数量不够，取料失败");
			}
		}
		
		try {
			
			mapper.backStore01(list, time);
			mapper.backStore02(list, time);
			return new BackMessage(200, "取料成功");
		} catch (Exception e) {
			// TODO: handle exception
			return new BackMessage(1000, "取料失败");
		}
	}
}
