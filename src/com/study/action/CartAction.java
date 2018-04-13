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
		// Ҫ�õ�������һ���飿��
		String bookid = request.getParameter("bookid");
		long id = Long.parseLong(bookid);
		QueryBookBiz querybook = new QueryBookBiz();
		querybook.setBizData(id);
		querybook.doBusiness();
		Book book = (Book) querybook.getResult();
		// ������ﳵΪ��
		List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
		if (cart == null) {
			// ����һ�����ﳵ������
			cart = new ArrayList<CartItem>();
			// ����CartItem
			CartItem item = new CartItem(book.getBookid(), book, 1);
			cart.add(item);
		} else {
			// ���ﳵ�����Ѿ���һ����ͬ����
			// true��ʾû����ͬ��
			boolean flag = true;
			for (CartItem item : cart) {
				if (item.getId() == id) {
					flag = false;
					item.setCount(item.getCount() + 1);
					break;
				}
			}
			if (flag) {
				// û����ͬ����
				CartItem item = new CartItem(book.getBookid(), book, 1);
				cart.add(item);
			}
		}
		// ���浽session
		session.setAttribute("cart", cart);
		return "SUCCESS";
	}

}
