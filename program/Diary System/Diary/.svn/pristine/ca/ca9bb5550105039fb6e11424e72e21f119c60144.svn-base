package com.sf.service;

import java.util.List;

import com.sf.model.Records;

public interface RecordsService {
	int deleteByUserid(Integer id);
	String selectIdByDate(String date);
    int insert(Records record);

    int insertSelective(Records record);

    List<Records> selectByUserid(String userid);
    List<Records> selectAll(Integer id);
    int updateByUseridSelective(Records record);
    int updateByIdSelective(Records record);

    int updateByUserid(Records record);
    int updateByDateSelective(Records record);
    
    
    
    public int selectCountByUserid(String userid);
}
