package com.wms.mapper.storemanagement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;

import com.wms.common.BackMessage;
import com.wms.model.BackOrTakeModel;

public interface SumStoreMapper {

	public List<BackOrTakeModel> sumStore();	
}
