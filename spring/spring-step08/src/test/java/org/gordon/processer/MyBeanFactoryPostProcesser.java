package org.gordon.processer;

import org.gordon.beans.BeansException;
import org.gordon.beans.PropertyValue;
import org.gordon.beans.PropertyValues;
import org.gordon.beans.factory.ConfigurableListableBeanFactory;
import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @Author:dongchen
 * @Date: 2023/3/26 16:02
 */
public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
		PropertyValues propertyValues = beanDefinition.getPropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("company","字节"));
	}
}
