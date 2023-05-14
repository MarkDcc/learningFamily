package org.gordon.beans.factory;

import org.gordon.beans.BeansException;

/**
 * @Author:dongchen
 * @Date: 2023/3/19 18:36
 */
public interface BeanFactory {
	/**
	 * 返回Bean的实例对象
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object getBean(String beanName) throws BeansException;

	/**
	 * 返回含有构造函数的Bean实例对象
	 * @param beanName
	 * @param args 构造函数的入参
	 * @return
	 * @throws BeansException
	 */
	Object getBean(String beanName,Object... args) throws BeansException;

	<T> T getBean(String beanName,Class<T> requiredType) throws BeansException;
}
