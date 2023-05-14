package org.gordon.beans.factory.config;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Author:dongchen
 * @Date: 2023/3/26 14:32
 */
public interface BeanFactoryPostProcessor {
	/**
	 * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
	 *
	 * @param beanFactory
	 * @throws BeansException
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
