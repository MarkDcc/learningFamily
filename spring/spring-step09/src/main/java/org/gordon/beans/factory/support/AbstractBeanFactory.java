package org.gordon.beans.factory.support;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.FactoryBean;
import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.BeanPostProcessor;
import org.gordon.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 14:59
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

	@Override
	public Object getBean(String beanName) {
		return doGetBean(beanName, null);
	}

	@Override
	public Object getBean(String beanName, Object... args) {
		return doGetBean(beanName, args);
	}

	@Override
	public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
		return (T) getBean(beanName);
	}

	private Object doGetBean(String beanName, Object... args) {
		Object singleton = getSingleton(beanName);

		if (singleton != null) {
			return getObjectForBeanInstance(singleton, beanName);
		}
		BeanDefinition beanDefinition = getBeanDefinition(beanName);
		Object bean = createBean(beanName, beanDefinition, args);
		return getObjectForBeanInstance(bean, beanName);
	}

	private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
		if (!(beanInstance instanceof FactoryBean)) {
			return beanInstance;
		}
		Object bean = getCachedObjectForFactoryBean(beanName);
		if (bean == null) {
			bean = getObjectFromFactoryBean((FactoryBean) beanInstance, beanName);
		}
		return bean;
	}

	abstract BeanDefinition getBeanDefinition(String beanName);

	abstract Object createBean(String beanName, BeanDefinition beanDefinition02, Object... args);

	@Override
	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
		this.beanPostProcessors.remove(beanPostProcessor);
		this.beanPostProcessors.add(beanPostProcessor);
	}

	public List<BeanPostProcessor> getBeanPostProcessors() {
		return beanPostProcessors;
	}

	public ClassLoader getBeanClassLoader() {
		return this.getClass().getClassLoader();
	}
}
