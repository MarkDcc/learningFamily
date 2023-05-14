package org.gordon.beans.factory.support;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.ConfigurableListableBeanFactory;
import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.BeanPostProcessor;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 14:52
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

//	@Override
//	BeanDefinition getBeanDefinition(String beanName) {
//		return beanDefinitionMap.get(beanName);
//	}

	@Override
	public void registryBeanDefinition(BeanDefinition beanDefinition, String beanName) {
		beanDefinitionMap.put(beanName,beanDefinition);
	}

	@Override
	public Boolean containerBeanDefinition(String beanName){
		return beanDefinitionMap.containsKey(beanName);
	}


	@Override
	public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
		Map<String ,T> result = new HashMap<>();
		beanDefinitionMap.forEach((beanName,beanDefinition)->{
			Class beanClass = beanDefinition.getBeanClass();
			if(type.isAssignableFrom(beanClass)){
				result.put(beanName, (T) getBean(beanName));
			}
		});
		return result;
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return beanDefinitionMap.keySet().toArray(new String[0]);
	}


	@Override
	public BeanDefinition getBeanDefinition(String beanName) {
		return beanDefinitionMap.get(beanName);
	}
}
