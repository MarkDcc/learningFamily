package com.gordon;

import com.gordon.bean.Tom;
import com.gordon.bean.User;
import com.gordon.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Demo01Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Demo01Application.class, args);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();

		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println("beanDefinitionName = " + beanDefinitionName);
		}
//
		User userxx = context.getBean("user01", User.class);
		System.out.println("userxx = " + userxx);
		User useryy = context.getBean(User.class);
		System.out.println("useryy = " + useryy);
//		System.out.println("userxx = " + userxx);

		MyConfig myConfig = context.getBean(MyConfig.class);
		System.out.println("myConfig = " + myConfig);
		User user02 = myConfig.user01();
		User user01 = myConfig.user01();
		System.out.println(user01);
		System.out.println(user02);
		System.out.println("(user01==userxx) = " + (user01 == userxx));
		System.out.println("user01==user02 = " + (user01 == user02));


		System.out.println("==========");

		Tom tom = context.getBean(Tom.class);
		System.out.println(tom);
		Tom tom1 = context.getBean(Tom.class);
		System.out.println("tom1 = " + tom1);
	}

}
