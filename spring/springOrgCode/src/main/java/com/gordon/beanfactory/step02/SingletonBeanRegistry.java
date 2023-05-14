package com.gordon.beanfactory.step02;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:01
 */
public interface SingletonBeanRegistry {
	 Object getSingleton(String beanName);
	 void registerSingleton(String beanName, Object singletonObject);
}
