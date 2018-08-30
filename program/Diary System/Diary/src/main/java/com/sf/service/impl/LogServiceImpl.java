package com.sf.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.mapper.LogMapper;
import com.sf.model.Log;
import com.sf.service.LogService;
import com.sf.util.StringUtil;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LogServiceImpl implements LogService {

	@Autowired private LogMapper logMapper;
	@Autowired private Log log;

	 
	public List<Log> selectAll(int page, int pageSize) {
		return logMapper.selectAll(page, pageSize);
	}

	 
	public List<Log> selectLogByUserid(String userid, int  page, int limit) {

		Integer offset = limit * (page - 1) + 1;   
		return logMapper.selectLogByUserid(userid, offset, limit);
	}

	 
	public int selectCount(int pageSize) {
		int pageCount = Integer.parseInt(logMapper.selectCount().getUserid());
		return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize + 1;
	}

	 
	public int selectCountByUserid(String userid) {
		
		int pageCount = logMapper.selectCountByUserid(userid);
		return pageCount;
	}


	 
	public boolean insert(Log log) {
		//        log.setId(StringUtil.getGuid());
		return logMapper.insert(log);
	}

	 
	public boolean delete(String id) {
		return logMapper.delete(id);
	}

	 
	public boolean deleteThisUser(String userid) {
		return logMapper.deleteThisUser(userid);
	}

	 
	public boolean deleteAll() {
		return logMapper.deleteAll();
	}
}
