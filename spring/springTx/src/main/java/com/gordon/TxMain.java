package com.gordon;

import com.gordon.pojo.Account;
import com.gordon.pojo.User;
import com.gordon.service.AccountService;
import com.gordon.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:dongchen
 * @Date: 2022/11/20 11:16
 */
public class TxMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		AccountService accountServiceImpl = (AccountService) context.getBean("accountServiceImpl");
		UserService userService = (UserService) context.getBean("userServiceImpl");
		Account account = new Account(100, "lisi", 101);
		User user = new User(200, "zhangsan", 15);
		//int addAccount = accountServiceImpl.addAccount(account);
		int addUser = userService.addUser(user);
		//System.out.println("addAccount = " + addAccount);
		System.out.println("addUser = " + addUser);
	}
}
