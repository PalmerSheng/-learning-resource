package com.sf.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sf.mapper.UserMapper;
import com.sf.model.UserInfo;
import com.sf.service.UserService;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired 
    private UserMapper userMapper;

     
    public List<UserInfo> selectAll(int page, int pageSize) {
        return userMapper.selectAll(page, pageSize);
    }

     
    public UserInfo selectUserByUserid(String userid) {
        return userMapper.selectUserByUserid(userid);
    }

     
    public int selectCount(int pageSize) {
        int pageCount = Integer.parseInt(userMapper.selectCount().getUserid());
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize + 1;
    }

     
    public boolean insert(UserInfo user) {
        return userMapper.insertSelective(user);
    }

     
    public boolean update(UserInfo user) {
        return userMapper.updateByUseridSelective(user);
    }

     
    public boolean delete(String userid) {
        return userMapper.deleteByUserid(userid);
    }
     
    public String selNickname(String userid){
    	return userMapper.selNickname(userid);
    }

	/* 
	public void addUser(String userid, String password) {
		// TODO Auto-generated method stub
		try {
			userMapper.addUser(userid,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}*/
    
    
}
