package com.sf.service;


import java.util.List;

import com.sf.model.UserInfo;


public interface UserService {
    List<UserInfo> selectAll(int page, int pageSize);
    UserInfo selectUserByUserid(String userid);
    int selectCount(int pageSize);
    boolean insert(UserInfo user);
    boolean update(UserInfo user);
    boolean delete(String userid);
    
    String selNickname(String userid);
  /*  int addUser(String userid,String password);*/
    
}
