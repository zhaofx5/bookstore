package com.study.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.study.business.LoginBiz;
import com.study.pojo.AdminUser;
import com.study.pojo.User;

public class LoginAction {
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username,password);
		
		LoginBiz login = new LoginBiz();
		login.setBizData(user);
		login.doBusiness();
	    user = (User) login.getResult();
		if(user == null)
		{
			String errormsg = "用户名或者密码错误";
			session.setAttribute("errormsg", errormsg);
			return "FAIL";
		}
		else
		{
			session.setAttribute("user", user);
			return "SUCCESS";
		}
	}
	public String adminLogin(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username = request.getParameter("name");
		String password = request.getParameter("password");
        AdminUser adminUser = new AdminUser(username,password);		
		LoginBiz login = new LoginBiz();
		login.setAdminBizData(adminUser);
		login.doAdminBusiness();
	    adminUser = (AdminUser) login.getAdminResult();
		if(adminUser == null)
		{
			String errormsg = "用户名或者密码错误";
			session.setAttribute("errormsg", errormsg);
			return "FAIL";
		}
		else
		{
			session.setAttribute("user", adminUser);
			return "SUCCESS";
		}
	}

}
