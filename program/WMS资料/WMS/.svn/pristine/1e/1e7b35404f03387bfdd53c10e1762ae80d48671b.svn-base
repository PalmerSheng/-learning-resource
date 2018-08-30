package com.wms.mapper.storemanagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;

import com.wms.common.BackMessage;
import com.wms.model.BackOrTakeModel;

public interface OnOrOutStoreMapper {

	// 进货
	public int backStore01(
			@Param("list") List<BackOrTakeModel> list, 
			@Param("time") String time);
	public int backStore02(
			@Param("list") List<BackOrTakeModel> list, 
			@Param("time") String time);
	public int backStore03(
			@Param("list") List<BackOrTakeModel> list, 
			@Param("time") String time);
	
	// 退货
	public int takeStore01(
			@Param("list") List<BackOrTakeModel> list, 
			@Param("time") String time);
	public int takeStore02(
			@Param("list") List<BackOrTakeModel> list, 
			@Param("time") String time);
	public List<BackOrTakeModel> takeStore03(
			@Param("list") List<BackOrTakeModel> list, 
			@Param("time") String time);
}
