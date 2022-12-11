package com.gordon.test;

import com.gordon.pojo.Account;
import com.gordon.pojo.User;
import com.gordon.service.AccountService;
import com.gordon.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:dongchen
 * @Date: 2022/11/20 11:37
 */
public class MyTest {

	@Test
	public void testAddUser(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		AccountService accountServiceImpl = (AccountService) context.getBean("accountServiceImpl");
		UserService userService = (UserService) context.getBean("userServiceImpl");

		User user = new User(200, "lisi", 15);

		int addUser = userService.addUser(user);

		System.out.println("addUser = " + addUser);
	}

	@Test
	public void testAddAccount(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		AccountService accountServiceImpl = (AccountService) context.getBean("accountServiceImpl");

		Account account = new Account(100, "zhangsan", 101);

		int addAccount = accountServiceImpl.addAccount(account);

		System.out.println("addAccount = " + addAccount);

	}
}
