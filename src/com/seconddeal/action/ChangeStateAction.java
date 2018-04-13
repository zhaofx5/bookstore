package com.seconddeal.action;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.seconddeal.business.ChangeState;

public class ChangeStateAction {
	private String SELLERNAME;

	public String getSELLERNAME() {
		return SELLERNAME;
	}

	public void setSELLERNAME(String sELLERNAME) {
		SELLERNAME = sELLERNAME;
	}

	public String query() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String SELLERNAME = request.getParameter("SELLERNAME");
//		解决编码问题
		byte b[] = SELLERNAME.getBytes("iso8859-1");
		SELLERNAME = new String(b,"utf-8");
		ChangeState cs = new ChangeState();
		cs.setSELLERNAME(SELLERNAME);
		cs.doBusiness();
		return "SUCCESS";
		}
}
