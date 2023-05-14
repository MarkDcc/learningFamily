package org.gordon.beans.factory.config;

import org.gordon.beans.BeansException;

/**
 * @Author:dongchen
 * @Date: 2023/3/26 14:32
 */
public interface BeanPostProcessor {
	/**
	 * 在 Bean 对象执行初始化方法之前，执行此方法
	 *
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

	/**
	 * 在 Bean 对象执行初始化方法之后，执行此方法
	 *
	 * @param bean
	 * @param beanName
	 * @return
	 * @throws BeansException
	 */
	Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;

}
