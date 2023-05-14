package com.gordon.beanfactory.step04;

import com.gordon.beanfactory.bean.UseDao;
import com.gordon.beanfactory.bean.UserService;
import com.gordon.beanfactory.step02.BeanDefinition02;
import com.gordon.beanfactory.step02.DefaultListableBeanFactory;
import com.gordon.beanfactory.step03.CglibSubclassingInstantiationStrategy;
import org.junit.Test;

/**
 * @Author:dongchen
 * @Date: 2023/3/19 10:24
 */
public class CreateBeanTest {

	@Test
	public void test(){
		//初始化beanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		CglibSubclassingInstantiationStrategy cglibSubclassingInstantiationStrategy = new CglibSubclassingInstantiationStrategy();
		beanFactory.setInstantiationStrategy(cglibSubclassingInstantiationStrategy);

		//注册useDao bean
		beanFactory.registryBeanDefinition(new BeanDefinition02(UseDao.class),"useDao");

		//注册userService,并进行属性填充
		BeanDefinition02 userServiceBeanDefinition = new BeanDefinition02(UserService.class);
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("uid", "1001"));
		propertyValues.addPropertyValue(new PropertyValue("useDao", new BeanReference("useDao")));
		userServiceBeanDefinition.setPropertyValues(propertyValues);
		beanFactory.registryBeanDefinition(userServiceBeanDefinition,"userService");



		UserService userService = (UserService) beanFactory.getBean("userService", "zhangsan");
		userService.queryUser();
	}
}
