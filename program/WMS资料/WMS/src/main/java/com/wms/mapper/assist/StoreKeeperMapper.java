package com.wms.mapper.assist;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.wms.model.UserInfoModel;

public interface StoreKeeperMapper {
	
	
	//修改信息表
	public int  UpdateStoreKeeperInfo(
			@Param("depart")String depart,
			@Param("group")String group1,
			@Param("username")String username,
			@Param("password")String password,
			@Param("usercode")String usercode,
			@Param("unit_code")String unit_code,
			@Param("level")String level,
			@Param("tel")String tel);
	
	//新增
	public int InsertStoreKeeperInfo(
				
			@Param("depart")String depart,
			@Param("group")String group1,
			@Param("id")String id,
			@Param("username")String username,
			@Param("usercode")String usercode,
			@Param("unit_code")String unit_code,
			@Param("level")String level,
			@Param("tel")String tel,
			@Param("password")String password
			);
	//删除管理员
	public Boolean DeleteStoreKeeperInfo(@Param("job")UserInfoModel job);
	/*public List<UserInfoModel> DeleteStoreKeeperInfo(
			@Param("username")String username,
			@Param("usercode")String usercode,
			@Param("unit_code")String unit_code,
			@Param("tel")String tel);*/
	
	//查询
	public List<UserInfoModel> StoreKeeperInfo(
			@Param("username")String username,
			@Param("usercode")String usercode);
}
