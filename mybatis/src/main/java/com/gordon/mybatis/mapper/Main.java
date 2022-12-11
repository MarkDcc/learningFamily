package com.gordon.mybatis.mapper;

import java.util.Arrays;

/**
 * @Author:dongchen
 * @Date: 2022/12/9 13:36
 */
public class Main {
	public static void main(String[] args) {
//		Arrays.asList("http.proxyHost").stream().map(System::getProperty).forEach(System.out::println);
		A a = new A();
		a.setName("zhangsan");
		A a1 =a;
		System.out.println(a.getName());
		System.out.println(a1.getName());
		a.setName("lisi");
		System.out.println("---------");
		System.out.println(a.getName());
		System.out.println(a1.getName());

	}

}
