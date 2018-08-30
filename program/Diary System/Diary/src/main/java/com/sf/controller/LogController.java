package com.sf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sf.common.BackMessage;
import com.sf.common.SystemControllerLog;
import com.sf.model.Log;
import com.sf.service.LogService;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * 
 * @author : sf
 * @time   : 2018年7月31日  下午4:44:56 
 * @TODO   :
 */
@Controller
@RequestMapping(value = "")
public class LogController {

    @Autowired
    private LogService logService;
    
    /**
     * 加载log
     * @param userid
     * @param page
     * @return
     */
    @RequestMapping(value = "{userid}/log")
    @SystemControllerLog("加载系统日志")
    public ModelAndView turnLog(@PathVariable("userid") String userid,HttpServletRequest req) {
//        Integer  page=(req.getParameter("page")==null ? 1:Integer.parseInt(req.getParameter("page").trim()));
//		Integer limit=(req.getParameter("limit")==null ? 5:Integer.parseInt(req.getParameter("limit").trim()));
 
        ModelAndView view = new ModelAndView("log");
//        List<Log> list = logService.selectLogByUserid(userid, page, limit);
//        int count = logService.selectCountByUserid(userid, limit);
//        view.addObject("list", list);
//        view.addObject("count", count);
        return view;
    }
    
    
    
    /**
     * 加载log
     * @param userid
     * @param page
     * @return
     */
    @RequestMapping(value = "{userid}/log1")
    @SystemControllerLog("查询系统日志记录")
    @ResponseBody
    public BackMessage selectAll(@PathVariable("userid") String userid,HttpServletRequest req) {
    	Integer  page=(req.getParameter("page")==null ? 1:Integer.parseInt(req.getParameter("page").trim()));
//		Integer limit=(req.getParameter("limit")==null ? 5:Integer.parseInt(req.getParameter("limit").trim()));
		Integer limit=(req.getParameter("limit")==null ? 5:5);
//        ModelAndView view = new ModelAndView("log");
        List<Log> list = logService.selectLogByUserid(userid, page, limit);
        int count = logService.selectCountByUserid(userid);
//        view.addObject("list", list);
//        view.addObject("count", count);
        return new BackMessage(0, "success", count, list);
    }

}
