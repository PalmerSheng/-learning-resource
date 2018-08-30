package com.sf.mapper;


import org.apache.ibatis.annotations.Param;

import com.sf.model.UserInfo;

import java.util.List;


public interface UserMapper {
    List<UserInfo> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    boolean deleteByUserid(String userid);

    /*int insert(UserInfo userinfo);*/

    boolean insertSelective(UserInfo userinfo);

    UserInfo selectUserByUserid(String userid);

    boolean updateByUseridSelective(UserInfo userinfo);

    /*int updateByPrimaryKey(UserInfo userinfo);*/
    /*boolean addUser(UserInfo userinfo);*/
    UserInfo selectCount();
    
    String selNickname(String userid);
}
