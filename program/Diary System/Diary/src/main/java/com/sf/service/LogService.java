package com.sf.service;


import java.util.List;

import com.sf.model.Log;

/**
 * 
 * @author : sf
 * @time   : 2018年8月4日  上午11:38:09 
 * @TODO   :
 */
public interface LogService {
    List<Log> selectAll(int page, int pageSize);
    List<Log> selectLogByUserid(String userid, int page, int limit);
    int selectCount(int pageSize);
    int selectCountByUserid(String userid);
    boolean insert(Log log);
    boolean delete(String id);
    boolean deleteThisUser(String userid);
    boolean deleteAll();
}
