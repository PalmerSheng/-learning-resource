package com.wms.serviceimpl.systemsetting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.common.BackMessage;
import com.wms.mapper.systemsetting.PwdModifiedMapper;
import com.wms.model.MessageDefined;
import com.wms.model.UserInfo;
import com.wms.service.systemsetting.PwdModifiedService;
import com.wms.util.GetToken;

@Service
public class PwdModifiedServiceImpl implements PwdModifiedService {

	@Autowired
     private PwdModifiedMapper pwdModifiedMapper = null;
	
	
	public BackMessage pwdModified(HttpServletRequest req,HttpServletResponse res) {
		// TODO Auto-generated method stub
		MessageDefined defined = new MessageDefined();
		BackMessage backMessage=null;
		String oldPassword = req.getParameter("oldPassword")==null?"":req.getParameter("oldPassword").trim();
		String newPassword = req.getParameter("newPassword")==null?"":req.getParameter("newPassword").trim();
		String checkPassword = req.getParameter("checkPassword")==null?"":req.getParameter("checkPassword").trim();
		if(oldPassword==""){
			backMessage = new BackMessage(1, defined.MODIFY_PWD_NULL);
			return backMessage;
		}else if (newPassword =="" || checkPassword=="") {
			backMessage = new BackMessage(1, defined.MODIFY_NEWPWD_NULL);
			return backMessage;
		}else if (!newPassword.equals(checkPassword)) {
			backMessage = new BackMessage(1, defined.MODIFY_NEWPWD_DIFFERENT);
			return backMessage;
		}
	
		UserInfo info = GetToken.TokenValue(req, res);
		String usercode = info.getUsercode();
		
		System.out.println(usercode+"usercode");
		System.out.println(newPassword+"newPassword");
		
		boolean flag = false;
		try {
			flag = pwdModifiedMapper.pwdModified(usercode,newPassword);
			if(flag==true){
				return new BackMessage(0, "success");
			}else{
				return new BackMessage(1, defined.MODIFY_FAILED);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new BackMessage(1, defined.PRAGRAM_EXCEPTION);
		}
	}

}
