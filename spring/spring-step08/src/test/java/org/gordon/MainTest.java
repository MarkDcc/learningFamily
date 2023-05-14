package org.gordon;

import cn.hutool.core.io.IoUtil;
import org.gordon.bean.UseDao;
import org.gordon.bean.UserService;
import org.gordon.beans.PropertyValue;
import org.gordon.beans.PropertyValues;
import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.BeanReference;
import org.gordon.beans.factory.support.CglibSubclassingInstantiationStrategy;
import org.gordon.beans.factory.support.DefaultListableBeanFactory;
import org.gordon.beans.factory.support.InstantiationStrategy;
import org.gordon.context.support.ClassPathXmlApplicationContext;
import org.gordon.io.DefaultResourceLoader;
import org.gordon.io.Resource;
import org.gordon.io.XmlBeanDefinitionReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 15:18
 */
public class MainTest {

	@Test
	public void test(){
		InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition(UseDao.class);
		beanFactory.registryBeanDefinition(beanDefinition,"useDao");
		beanFactory.setInstantiationStrategy(instantiationStrategy);
		UseDao useDao = (UseDao) beanFactory.getBean("useDao");
		//System.out.println(useDao.queryUser("1001"));
		//获取带有属性的对象

		BeanDefinition userServiceDefinition = new BeanDefinition(UserService.class);
		BeanReference useDaoBeanReference = new BeanReference("useDao");
//		userServiceBeanReference
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("uid","1002"));
		propertyValues.addPropertyValue(new PropertyValue("name", "zhangsan"));
		propertyValues.addPropertyValue(new PropertyValue("useDao", useDaoBeanReference));
		userServiceDefinition.setPropertyValues(propertyValues);

		beanFactory.registryBeanDefinition(userServiceDefinition, "userService");
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUser();
	}

	private DefaultResourceLoader resourceLoader;

	@Before
	public void init() {
		resourceLoader = new DefaultResourceLoader();
		//InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
	}

	@Test
	public void test_classpath() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:important.properties");
		InputStream inputStream = resource.getInputStream();
		String content = IoUtil.readUtf8(inputStream);
		System.out.println(content);
	}

	@Test
	public void test_xml() throws ClassNotFoundException {
		// 1.初始化 BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 2. 读取配置文件&注册Bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions("classpath:spring.xml");

		// 3. 获取Bean对象调用方法
		UserService userService = (UserService) beanFactory.getBean("userService", UserService.class);
		userService.queryUser();
		System.out.println(userService.getCompany());
		//System.out.println("测试结果：" + result);
	}

	@Test
	public void test_beanFactoryPostPorcesser(){
		// 1.初始化 BeanFactory
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

		UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService");

		userService.queryUser();
		System.out.println(userService.getCompany());
		System.out.println(userService.getLocation());
		classPathXmlApplicationContext.destroy();
		//System.out.println("测试结果：" + result);
	}
}
