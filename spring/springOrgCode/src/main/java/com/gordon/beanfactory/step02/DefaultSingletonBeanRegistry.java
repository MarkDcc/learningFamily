package com.gordon.beanfactory.step02;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:02
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{
	private Map<String ,Object> beanDefinition02Map = new HashMap<>();
	@Override
	public Object getSingleton(String beanName) {
		return beanDefinition02Map.get(beanName);
	}

	@Override
	public void registerSingleton(String beanName, Object singletonObject) {
		beanDefinition02Map.put(beanName,singletonObject);
	}
}
