package com.seconddeal.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;

import com.seconddeal.business.SaveGoods;
import com.seconddeal.pojo.Goods;

public class SaveAction {
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
		//上传二手物品实物图
		String path = ServletActionContext.getServletContext().getRealPath("upLoad");
		//为二手物品重新命名
		String filename = (int)(Math.random()*1000000)+".jpg";
		File desk = new File(path+"/"+filename);
		try {
			FileUtil.copyFile(upLoad, desk);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String GOODSNAME = request.getParameter("GOODSNAME");
		String DETAIL =  request.getParameter("DETAIL");
		String PRICE = request.getParameter("PRICE");
		String PIC = filename;
		String SELLERNAME = request.getParameter("SELLERNAME");
		String TEL = request.getParameter("TEL");
		int STATE = 0;
		Goods good = new Goods(GOODSNAME, DETAIL, PRICE, PIC, SELLERNAME, TEL, STATE);
		SaveGoods saveGoods = new SaveGoods();
		saveGoods.setBizData(good);
		saveGoods.doBusiness();
		return "SUCCESS";
	}
	public File getUpLoad() {
		return upLoad;
	}

}
