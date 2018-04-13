package com.seconddeal.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.seconddeal.dao.GoodsDao;
import com.seconddeal.pojo.Goods;
import com.study.jdbc.utils.JdbcUtils;

public class QueryAllGoods {
	private GoodsDao goodsDao = new GoodsDao();
	private List<Goods> goods;
	
	public void doBusiness()
	{
		Connection conn = null;
		 try {
			conn = JdbcUtils.getConn();
			goodsDao.setConn(conn);
			goods = goodsDao.queryGoods();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public Object getResult()
	{
		return goods;
	}

}
