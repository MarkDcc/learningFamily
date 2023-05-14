package com.gordon.beanfactory.step02;

import com.gordon.beanfactory.bean.UserService;
import com.gordon.beanfactory.step03.CglibSubclassingInstantiationStrategy;
import com.gordon.beanfactory.step03.SimpleInstantiationStrategy;
import org.junit.Test;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:38
 */
public class Step02MainTest {
	@Test
	public void test(){
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		BeanDefinition02 beanDefinition02 = new BeanDefinition02(UserService.class);

		beanFactory.registryBeanDefinition(beanDefinition02,"userService");

//		beanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());
		beanFactory.setInstantiationStrategy(new CglibSubclassingInstantiationStrategy());
		UserService userService = (UserService) beanFactory.getBean("userService","zhangsan");
		userService.queryUser();
		System.out.println("第一次获取对象："+userService);
		System.out.println("第二次获取对象："+beanFactory.getBean("userService"));
	}
}
