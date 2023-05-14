package org.gordon.context.support;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.ApplicationContextAware;
import org.gordon.beans.factory.config.BeanPostProcessor;
import org.gordon.context.ApplicationContext;

/**
 * @Author:dongchen
 * @Date: 2023/4/9 16:08
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
	private final ApplicationContext applicationContext;

	public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof ApplicationContextAware){
			((ApplicationContextAware) bean).setApplicationContext(applicationContext);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
