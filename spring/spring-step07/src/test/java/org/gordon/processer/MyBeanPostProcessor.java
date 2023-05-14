package org.gordon.processer;

import org.gordon.bean.UserService;
import org.gordon.beans.BeansException;
import org.gordon.beans.factory.config.BeanPostProcessor;

/**
 * @Author:dongchen
 * @Date: 2023/3/26 16:18
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("userService")){
			UserService userService = (UserService) bean;
			userService.setLocation("新北京");
		}
		return bean;

	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println(beanName+" 我是一个后置处理器");
		return bean;
	}
}
