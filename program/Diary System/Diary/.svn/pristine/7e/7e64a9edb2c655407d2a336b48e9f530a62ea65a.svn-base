package com.sf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sf.model.Records;

public interface RecordsMapper {
    int deleteByUserid(Integer userid);

    int insert(Records record);

    int insertSelective(Records record);
    String selectIdByDate(String date);
    List<Records>  selectByUserid(String userid);
    
    List<Records>  selectAll();

    int updateByUseridSelective(Records record);
    int updateByDateSelective(Records record);
    
    public int updateByIdSelective(Records record);

    int updateByUserid(Records record);
    
    int selectCountByUserid(@Param("userid")String userid);
}