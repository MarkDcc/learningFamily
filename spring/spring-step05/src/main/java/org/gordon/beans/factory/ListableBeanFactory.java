package org.gordon.beans.factory;

import org.gordon.beans.BeansException;

import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/3/19 19:36
 */
public interface ListableBeanFactory extends BeanFactory{

	/**
	 * 按照类型返回 Bean实例
	 * @param type
	 * @return
	 * @param <T>
	 * @throws BeansException
	 */
	<T> Map<String,T> getBeansOfType(Class<T> type) throws BeansException;

	String[] getBeanDefinitionNames();
}
