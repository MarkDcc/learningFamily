package org.gordon.beans.factory.config;

/**
 * @Author:dongchen
 * @Date: 2023/3/19 19:50
 */
public interface SingletonBeanRegistry {
	Object getSingleton(String beanName);
	void registerSingleton(String beanName, Object singletonObject);
}
