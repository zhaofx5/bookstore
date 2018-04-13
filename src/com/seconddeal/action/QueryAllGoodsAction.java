package com.seconddeal.action;

import java.util.List;

import com.seconddeal.business.QueryAllGoods;
import com.seconddeal.pojo.Goods;

public class QueryAllGoodsAction {
	private List<Goods> goods;

	public List<Goods> getGoods() {
		return goods;
	}
	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	//查询所有二手物品的方法
	public String query(){
	QueryAllGoods qag = new QueryAllGoods();
	qag.doBusiness();
	goods = (List<Goods>) qag.getResult();
	return "SUCCESS";
	}

}
