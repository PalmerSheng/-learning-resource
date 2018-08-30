package com.sf.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.sf.model.Log;

import java.util.List;

/**
 * 
 * @author : sf
 * @time   : 2018年8月4日  上午11:37:28 
 * @TODO   :
 */
@Service(value = "logDao")
public interface LogMapper {
    List<Log> selectAll(@Param("offset") int offset, @Param("limit") int limit);

    List<Log> selectLogByUserid(@Param("userid") String userid, @Param("offset") int offset, @Param("limit") int limit);

    Log selectCount();

    int selectCountByUserid(@Param("userid") String userid);

    boolean insert(Log log);

    boolean delete(String id);

    boolean deleteThisUser(String userid);

    boolean deleteAll();
}
