package com.wxl.practice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wxl.model.CollegeInfo;

public interface CollegeMapper {

	public ArrayList<CollegeInfo>  College_getCollegeInfo(@Param("strCollegeName")String strCollegeName,@Param("limit")Integer limit,@Param("offset")Integer offset );
	
	public List<CollegeInfo>  College_getAllCollegeInfo();
	
	public int  College_getAllPage();
	
	public int College_getTotal(@Param("strCollegeName")String strCollegeName);
	public ArrayList<CollegeInfo>  TestDB();
    public int College_updCollegeInfo(@Param("CollegeInfo")CollegeInfo obj);
    public int College_del(@Param("strCollageId")String strCollageId);
    public CollegeInfo Collage_getCollageId(@Param("strCollageId")String strCollageId);
    public int College_insertInfo(@Param("strCollegeCode")String strCollegeCode,@Param("strCollegeName")String strCollegeName);
}
