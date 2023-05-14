package org.gordon.beans.factory.support;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.BeanFactory;
import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.BeanPostProcessor;
import org.gordon.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 14:59
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
	@Override
	public Object getBean(String beanName) {
		return doGetBean(beanName,null);
	}

	@Override
	public Object getBean(String beanName, Object... args) {
		return doGetBean(beanName,args);
	}

	@Override
	public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
		return (T) getBean(beanName);
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

	@Override
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		this.beanPostProcessors.remove(beanPostProcessor);
		this.beanPostProcessors.add(beanPostProcessor);
	}

	public List<BeanPostProcessor> getBeanPostProcessors() {
		return beanPostProcessors;
	}

	public ClassLoader getBeanClassLoader(){
		return this.getClass().getClassLoader();
	}
}
