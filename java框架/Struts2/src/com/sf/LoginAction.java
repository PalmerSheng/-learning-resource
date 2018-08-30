package com.sf;


import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {
	private String account;
	private String password;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception{
		if(account.equals(password)){
//			System.out.println("success");
			return "success";
		}else{
//			System.out.println("fail");
			return "fail";
		}
	}
}
