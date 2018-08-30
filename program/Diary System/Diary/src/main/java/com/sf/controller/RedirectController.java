package com.sf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sf.common.SystemControllerLog;
import com.sf.model.UserInfo;
import com.sf.service.UserService;

/**
 * 
 * @author : sf
 * @time   : 2018年7月31日  下午4:45:06 
 * @TODO   :重定向
 */
@Controller
@SessionAttributes("userid")
public class RedirectController {
	
	private UserInfo user;
	
	@Resource private UserService userService;
	
	
	/**
     * 显示个人信息页面
     */
    @RequestMapping(value = "{userid}", method = RequestMethod.GET)
    @SystemControllerLog("进入个人信息页面")
    public ModelAndView selectUserByUserid(@PathVariable("userid") String userid, @ModelAttribute("userid") String sessionid){
        ModelAndView view = new ModelAndView("information");
        user = userService.selectUserByUserid(userid);
        view.addObject("user", user);
        return view;
    }
    
    @RequestMapping(value = "/system")
    @SystemControllerLog("进入系统设置页面")
    public String system() {
        return "system-setting";
    }
    
    @RequestMapping(value = "/about")
    @SystemControllerLog("进入关于页面")
    public String about() {
        return "about";
    }
    
    @RequestMapping(value = "/help")
    @SystemControllerLog("进入帮助页面")
    public String help() {
        return "help";
    }
}
