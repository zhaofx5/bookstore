package com.study.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.study.business.RegBiz;
import com.study.pojo.User;

public class RegAction {
	private File upLoad;
	private String upLoadFileName;
	
	
	public void setUpLoad(File upLoad) {
		this.upLoad = upLoad;
	}
	public String getUpLoadFileName() {
		return upLoadFileName;
	}
	public void setUpLoadFileName(String upLoadFileName) {
		this.upLoadFileName = upLoadFileName;
	}

	public String execute(){
		//上传头像
		String path = ServletActionContext.getServletContext().getRealPath("upLoad");
		String filename = (int)(Math.random()*1000000)+".jpg";
		File desk = new File(path+"/"+filename);
		try {
			FileUtil.copyFile(upLoad, desk);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		User user = new User(username,password,filename);
		
		RegBiz reg = new RegBiz();
		reg.setBizData(user);
		reg.doBusiness();
	    String result =  reg.getResult();
		if(result == null)
		{
			String errormsg = "用户名已经存在 ";
			session.setAttribute("errormsg", errormsg);
			return "FAIL";
		}
		else
		{
			return "SUCCESS";
		}
	}
	public File getUpLoad() {
		return upLoad;
	}

}
