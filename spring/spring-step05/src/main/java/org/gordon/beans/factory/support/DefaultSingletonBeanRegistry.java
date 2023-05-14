package org.gordon.beans.factory.support;

import org.gordon.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:02
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	private Map<String ,Object> beanDefinitionMap = new HashMap<>();
	@Override
	public Object getSingleton(String beanName) {
		return beanDefinitionMap.get(beanName);
	}

	@Override
	public void registerSingleton(String beanName, Object singletonObject) {
		beanDefinitionMap.put(beanName,singletonObject);
	}
}
