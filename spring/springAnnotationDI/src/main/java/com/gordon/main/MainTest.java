package com.gordon.main;

import com.gordon.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 17:27
 */
public class MainTest {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		User user = (User) context.getBean("user");
		System.out.println("user = " + user);
	}
}
