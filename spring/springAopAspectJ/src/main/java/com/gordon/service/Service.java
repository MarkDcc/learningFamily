package com.gordon.service;

import com.gordon.pojo.User;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 19:46
 */
public interface Service {

	void buy();
	int get(String s);
	User findUserName(User user);

}
