package com.wms.mapper.query;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wms.model.GoodsModel;

public interface StockQueryMapper {
	//加载信息表
		public List<GoodsModel> GetStockInfo();
		//查询
		public List<GoodsModel> StockQuery(
				@Param("goods_code")String goods_code,
				@Param("goods_name")String goods_name
				
				
				);
}
