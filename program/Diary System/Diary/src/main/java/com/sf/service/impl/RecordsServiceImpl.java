package com.sf.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.mapper.RecordsMapper;
import com.sf.model.Records;
import com.sf.service.RecordsService;

@Service
public class RecordsServiceImpl implements RecordsService {

	@Autowired
	private RecordsMapper recordsMapper;

	 
	public int deleteByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return recordsMapper.deleteByUserid( userid);
	
	}

	 
	public int insert(Records record) {
		// TODO Auto-generated method stub
		return recordsMapper.insert( record);
	}

	 
	public int insertSelective(Records record) {
		// TODO Auto-generated method stub
		return recordsMapper.insertSelective( record);
	}
	

	 
	public String selectIdByDate(String date) {
		// TODO Auto-generated method stub
		return recordsMapper.selectIdByDate( date);
	}

	 
	public List<Records> selectByUserid(String userid) {
		// TODO Auto-generated method stub
		return recordsMapper.selectByUserid( userid);
	}

	 
	public int updateByUseridSelective(Records record) {
		// TODO Auto-generated method stub
		return recordsMapper.updateByUseridSelective( record);
	}

	 
	public int updateByIdSelective(Records record) {
		// TODO Auto-generated method stub
		return recordsMapper.updateByIdSelective( record);
	}

	 
	public int updateByDateSelective(Records record) {
		// TODO Auto-generated method stub
		return recordsMapper.updateByDateSelective(record);
	}

	 
	public int updateByUserid(Records record) {
		// TODO Auto-generated method stub
		return recordsMapper.updateByUserid( record) ;
	}

	 
	public List<Records> selectAll(Integer id) {
		// TODO Auto-generated method stub
		return recordsMapper.selectAll();
	}
	 
	public int selectCountByUserid(String userid) {
		// TODO Auto-generated method stub
		return recordsMapper.selectCountByUserid(userid);
	}
	
}
