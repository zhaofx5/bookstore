package com.study.action;

import java.util.Scanner;

import com.study.business.QueryBookBiz;

public class Test {
	public static void main(String[] args){
		QueryBookBiz qb = new QueryBookBiz();
		System.out.print(qb);
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		System.out.println(a);
	}

}
