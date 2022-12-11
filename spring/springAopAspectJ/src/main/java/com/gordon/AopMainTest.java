package com.gordon;

import com.gordon.pojo.User;
import com.gordon.service.MyService;
import com.gordon.service.Service;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 19:46
 */
public class AopMainTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationConfig.xml");
		Service myService = (Service) context.getBean("myService");
		//myService.buy();
		int result = myService.get("1");
		System.out.println(result);
		//User user = myService.findUserName(new User());
		///System.out.println(user);
		//System.out.println(myService.getClass());
	}
}
