package com.seconddeal.business;

import java.sql.Connection;
import java.sql.SQLException;

import com.seconddeal.dao.GoodsDao;
import com.study.jdbc.utils.JdbcUtils;

public class ChangeState {
	private String SELLERNAME;
	private GoodsDao goodsDao = new GoodsDao();
	private String resultCode;
	
	public void doBusiness()
	{
		Connection conn = null;
		try {
			conn = JdbcUtils.getConn();
			goodsDao.setConn(conn);
			goodsDao.ChangeState(SELLERNAME);
			conn.commit();
			resultCode = "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultCode=e.getMessage();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String getResult()
	{
		return resultCode;
	}

	public void setSELLERNAME(String sELLERNAME) {
		SELLERNAME = sELLERNAME;
	}
	
	

}
