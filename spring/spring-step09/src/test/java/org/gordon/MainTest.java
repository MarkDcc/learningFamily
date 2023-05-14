package org.gordon;

import org.gordon.bean.UserService;
import org.gordon.context.support.ClassPathXmlApplicationContext;
import org.gordon.io.DefaultResourceLoader;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 15:18
 */
public class MainTest {

	private DefaultResourceLoader resourceLoader;

	@Before
	public void init() {
		resourceLoader = new DefaultResourceLoader();
		//InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
	}

	@Test
	public void testFactoryBean(){
	    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
		applicationContext.getBean("proxyFactoryBean");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.queryUser();
	}
}
