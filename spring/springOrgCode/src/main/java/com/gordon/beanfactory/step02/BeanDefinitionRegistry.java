package com.gordon.beanfactory.step02;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:34
 */
public interface BeanDefinitionRegistry {

	void registryBeanDefinition(BeanDefinition02 beanDefinition02, String beanName);
}
