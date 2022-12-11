package com.gordon.service;

import com.gordon.pojo.User;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 19:46
 */
public class MyService implements Service{
	@Override
	public void buy() {
		System.out.println("实现类 buy...");
	}

	@Override
	public int get(String s) {
		System.out.println("实现类 get....");
		System.out.println(1/0);
		return 0;
	}

	@Override
	public User findUserName(User user) {
		System.out.println("实现类 findUserName....");
		System.out.println("实现类 findUserName user = " + user);
		//System.out.println(1/0);
		return new User();
	}
}
