package org.gordon.beans.factory.support;

import org.gordon.beans.factory.config.BeanDefinition;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 14:53
 */
public interface BeanDefinitionRegistry {
	void registryBeanDefinition(BeanDefinition beanDefinition, String beanName);
	Boolean containerBeanDefinition(String beanName);
}
