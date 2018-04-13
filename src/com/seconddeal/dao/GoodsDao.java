package com.seconddeal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seconddeal.pojo.Goods;

public class GoodsDao {
	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public void saveGoods(Goods goods) throws SQLException
	{
		String sql = "insert into bookstore.`tb_goods` values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, goods.getGOODSNAME());
		ps.setString(2, goods.getDETAIL());
		ps.setString(3, goods.getPRICE());
		ps.setString(4, goods.getPIC());
		ps.setString(5, goods.getSELLERNAME());
		ps.setString(6, goods.getTEL());
		ps.setInt(7, 0);
		ps.execute();
	}
	
	public List<Goods> queryGoods() throws SQLException
	{
		String sql ="select * from bookstore.`tb_goods` ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Goods> goods = new ArrayList<Goods>();
		Goods good = null;
		while(rs.next())
		{
			String GOODSNAME = rs.getString("GOODSNAME");
			String DETAIL =  rs.getString("DETAIL");
			String PRICE = rs.getString("PRICE");
			String PIC = rs.getString("PIC");
			String SELLERNAME = rs.getString("SELLERNAME");
			String TEL = rs.getString("TEL");
			int STATE = rs.getInt("STATE");
			if(STATE == 1){
			good = new Goods(GOODSNAME, DETAIL, PRICE, PIC, SELLERNAME, TEL, STATE);
			goods.add(good);}
			else{
			 System.out.print("这个物品不予展示");	
			}
				
		}
		
		return goods;
		
	}
//	根据物品的状态是否给予展示
	public List<Goods> testGoods() throws SQLException
	{
		String sql ="select * from bookstore.`tb_goods` ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Goods> goods = new ArrayList<Goods>();
		Goods good = null;
		while(rs.next())
		{
			String GOODSNAME = rs.getString("GOODSNAME");
			String DETAIL =  rs.getString("DETAIL");
			String PRICE = rs.getString("PRICE");
			String PIC = rs.getString("PIC");
			String SELLERNAME = rs.getString("SELLERNAME");
			String TEL = rs.getString("TEL");
			int STATE = rs.getInt("STATE");
			if(STATE == 0){
			good = new Goods(GOODSNAME, DETAIL, PRICE, PIC, SELLERNAME, TEL, STATE);
			goods.add(good);}
			else{
			 System.out.print("这是已经获得展示权限的物品"+GOODSNAME);	
			}
				
		}
		
		return goods;
		
	}
//	审核通过修改物品的ＳＴＡＴＥ
	public void ChangeState(String SELLERNAME)throws SQLException{
		String sql ="UPDATE bookstore.`tb_goods` SET STATE = '1' WHERE SELLERNAME = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, SELLERNAME);
		ps.execute();

	}
//	审核不通过删除物品
	public void deleteGoods(String SELLERNAME) throws SQLException{
		String sql = "DELETE FROM bookstore.`tb_goods` WHERE SELLERNAME = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, SELLERNAME);
		ps.execute();

	}
}
