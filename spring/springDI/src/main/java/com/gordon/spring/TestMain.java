package com.gordon.spring;

import com.gordon.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 15:57
 */
public class TestMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");

		User user = (User)applicationContext.getBean("user");
		System.out.println("user = " + user);
	}
}
