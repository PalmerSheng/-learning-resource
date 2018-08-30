package com.wms.serviceimpl.systemsetting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wms.common.BackMessage;
import com.wms.mapper.systemsetting.PrivilegeManageMapper;
import com.wms.model.LoginLeftBar;
import com.wms.service.systemsetting.PrivilegeManageService;

@Service
public class PrivilegeManageServiceImpl implements PrivilegeManageService {

	@Autowired
	private PrivilegeManageMapper privilegeManageMapper;

	public List<Object> getPrivilege(HttpServletRequest req) {
		// TODO Auto-generated method stub
			try {
				String level = req.getParameter("level")==null?"4":req.getParameter("level").trim();
				
				return privilegeManageMapper.getPrivilege(level);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
	}
	
	public int UpdateUserPrivilege(String level,String treelevels){

		int num=0;
		List<String> treelevelList=new ArrayList<String>();
		treelevelList=Arrays.asList(treelevels.split(","));
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("level",level);
		map.put("treelevels", treelevelList);
		
		privilegeManageMapper.DeletePrivileges(level);
		if(treelevels==null||treelevels==""){
			num=0;
			return num;
		}
		num=privilegeManageMapper.AddPrivileges(map);
		return num;
	}
	
	

}
