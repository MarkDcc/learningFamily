package org.gordon.beans.factory.support;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.BeanFactory;
import org.gordon.beans.factory.config.BeanDefinition;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 14:59
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
	@Override
	public Object getBean(String beanName) {
		return doGetBean(beanName,null);
	}

	@Override
	public Object getBean(String beanName, Object... args) {
		return doGetBean(beanName,args);
	}

	private Object doGetBean(String beanName, Object... args) {
		Object singleton = getSingleton(beanName);
		if(singleton != null){
			return singleton;
		}
		BeanDefinition beanDefinition = getBeanDefinition(beanName);
		return createBean(beanName, beanDefinition,args);
	}

	abstract BeanDefinition getBeanDefinition(String beanName);

	abstract Object createBean(String beanName,BeanDefinition beanDefinition02,Object... args);

}
