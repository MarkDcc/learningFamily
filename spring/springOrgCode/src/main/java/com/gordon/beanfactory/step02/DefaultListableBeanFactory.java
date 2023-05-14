package com.gordon.beanfactory.step02;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:33
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

	private Map<String,BeanDefinition02> beanDefinition02Map = new HashMap<>();
	@Override
	BeanDefinition02 getBeanDefinition02(String beanName) {
		return beanDefinition02Map.get(beanName);
	}

	@Override
	public void registryBeanDefinition(BeanDefinition02 beanDefinition02, String beanName) {
		beanDefinition02Map.put(beanName,beanDefinition02);
	}
}
