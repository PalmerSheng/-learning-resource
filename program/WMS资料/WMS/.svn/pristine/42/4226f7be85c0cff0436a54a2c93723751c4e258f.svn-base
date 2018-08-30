package com.wms.mapper.assist;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpRequest;

import com.wms.model.SupplyInfoModel;
import com.wms.model.UserInfoModel;

public interface SupplyInfoMapper {
	
	
	   //修改
		public int UpdateSupplyInfo(
				@Param("supply_name")String supply_name,
				@Param("supply_code")String supply_code,
				@Param("duty_name")String duty_name,//负责人
				@Param("tel")String tel);
		//新增管理员信息
		public int InsertSupplyInfo(
				@Param("supply_name")String supply_name,
				@Param("supply_code")String supply_code,
				@Param("duty_name")String duty_name,//负责人
				@Param("tel")String tel);
		//删除管理员
		public Boolean DeleteSupplyInfo(@Param("supply_code")String supply_code);
		//查询
		public List<SupplyInfoModel> Info(
				@Param("supply_name")String supply_name,
				@Param("supply_code")String supply_code);
		
}
