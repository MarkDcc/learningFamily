package org.gordon.beans.factory.support;

import org.gordon.beans.factory.config.BeanDefinition;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 14:52
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

	@Override
	BeanDefinition getBeanDefinition(String beanName) {
		return beanDefinitionMap.get(beanName);
	}

	@Override
	public void registryBeanDefinition(BeanDefinition beanDefinition, String beanName) {
		beanDefinitionMap.put(beanName,beanDefinition);
	}

	@Override
	public Boolean containerBeanDefinition(String beanName){
		return beanDefinitionMap.containsKey(beanName);
	}
}
