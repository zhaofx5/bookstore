package com.study.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.study.business.QueryBookBiz;
import com.study.pojo.Book;
import com.study.pojo.CartItem;

public class CartAction {
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// 要得到加入哪一本书？？
		String bookid = request.getParameter("bookid");
		long id = Long.parseLong(bookid);
		QueryBookBiz querybook = new QueryBookBiz();
		querybook.setBizData(id);
		querybook.doBusiness();
		Book book = (Book) querybook.getResult();
		// 如果购物车为空
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		if (cart == null) {
			// 创建一个购物车的篮子
			cart = new ArrayList<CartItem>();
			// 构建CartItem
			CartItem item = new CartItem(book.getBookid(), book, 1);
			cart.add(item);
		} else {
			// 购物车里面已经有一个相同的书
			// true表示没有相同的
			boolean flag = true;
			for (CartItem item : cart) {
				if (item.getId() == id) {
					flag = false;
					item.setCount(item.getCount() + 1);
					break;
				}
			}
			if (flag) {
				// 没有相同的项
				CartItem item = new CartItem(book.getBookid(), book, 1);
				cart.add(item);
			}
		}
		// 保存到session
		session.setAttribute("cart", cart);
		return "SUCCESS";
	}

}
