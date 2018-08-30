package com.wms.mapper.storemanagement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wms.common.BackMessage;
import com.wms.model.BackOrTakeModel;

public interface BackOrTakeStoreMapper {

	//查询商品
	public List<BackOrTakeModel> selGoods(
			@Param("goods_code")String goods_code);
	
	//退货
	public int backStore01(
			@Param("list")List<BackOrTakeModel> list,
			@Param("time")String time);
	public int backStore02(
			@Param("list")List<BackOrTakeModel> list,
			@Param("time")String time);

	//取货
	public int takeStore01(
			@Param("list")List<BackOrTakeModel> list,
			@Param("time")String time);
	public int takeStore02(
			@Param("list")List<BackOrTakeModel> list,
			@Param("time")String time);
	public List<BackOrTakeModel> takeStore03(
			@Param("list")List<BackOrTakeModel> list,
			@Param("time")String time);
}
