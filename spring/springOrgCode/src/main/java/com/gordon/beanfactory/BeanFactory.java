package com.gordon.beanfactory;

import java.util.HashMap;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 13:46
 */
public class BeanFactory {

	public HashMap<Object,BeanDefinition> beanDefinitionHashMap = new HashMap<>();

	public void registryBeanDefinition(BeanDefinition beanDefinition,Object beanName){
		beanDefinitionHashMap.put(beanName,beanDefinition);
	}

	public Object getBean(Object beanName) {
		return beanDefinitionHashMap.get(beanName).getBean();
	}
}
