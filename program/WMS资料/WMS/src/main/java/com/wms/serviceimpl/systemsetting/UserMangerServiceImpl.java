package com.wms.serviceimpl.systemsetting;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern.Flag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.common.BackMessage;
import com.wms.mapper.storemanagement.BackOrTakeStoreMapper;
import com.wms.mapper.systemsetting.UserMangerMapper;
import com.wms.model.MessageDefined;
import com.wms.model.UserInfo;
import com.wms.service.systemsetting.UserMangerService;

@Service
@SuppressWarnings("all")
public class UserMangerServiceImpl implements UserMangerService{

	@Autowired
	private UserMangerMapper mapper;
	
	public BackMessage selUser(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
		try {
			String usercode = this.getStr("usercode", req);
			String username = this.getStr("username", req);
			List<UserInfo> list = mapper.selUser(username, usercode);
			return new BackMessage(0, "查询用户信息成功", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1, "查询用户信息失败");
		}
		
	}

	private String getStr(String str, HttpServletRequest req) {

		String newStr = req.getParameter(str)==null?"":req.getParameter(str).trim();
		
		return newStr;
	}
	
	public BackMessage delUser(HttpServletRequest req, HttpServletResponse res){
		boolean flag = false;
		try {
			String usercode = req.getParameter("usercode")==null?"":req.getParameter("usercode").trim();
			flag = mapper.delUser(usercode);	
			if(flag==true){
				
				return new BackMessage(0, "删除用户成功");
			}
			return new BackMessage(1, "删除用户失败");
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1, "删除用户失败");
		}
	}
	
	
	
public BackMessage updateUserInfo(HttpServletRequest req,HttpServletResponse res,MessageDefined defined){
		
		try {
			boolean flag = false;
			String username = (req.getParameter("username") == null ? "" :(req.getParameter("username").trim()));
			String usercode = (req.getParameter("usercode") == null ? "" :(req.getParameter("usercode").trim()));
			String level = (req.getParameter("level") == null ? "" :(req.getParameter("level").trim()));
			String password = (req.getParameter("password") == null ? "" :(req.getParameter("password").trim()));
			String user_state = (req.getParameter("user_state") == null ? "" :(req.getParameter("user_state").trim()));
			String tel = (req.getParameter("tel") == null ? "" :(req.getParameter("tel").trim()));
			UserInfo userInfo = new UserInfo();
			userInfo.setUsercode(usercode);
			userInfo.setUsername(username);
			userInfo.setPassword(password);
			userInfo.setLevel(level);
			userInfo.setUser_state(user_state);
			userInfo.setTel(tel);
			
			
			flag = mapper.updateUserInfo(userInfo);
			if(flag!=false){
				return new BackMessage(0, "更新成功");
			}else{
				return new BackMessage(1, "更新失败");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1, defined.PRAGRAM_EXCEPTION);
		}
		
	}
}
