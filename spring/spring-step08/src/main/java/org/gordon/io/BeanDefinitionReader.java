package org.gordon.io;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.support.BeanDefinitionRegistry;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 17:21
 */
public interface BeanDefinitionReader {
	BeanDefinitionRegistry getRegistry();

	ResourceLoader getResourceLoader();

	void loadBeanDefinitions(Resource resource) throws BeansException, ClassNotFoundException;

	void loadBeanDefinitions(Resource... resources) throws BeansException, ClassNotFoundException;

	void loadBeanDefinitions(String location) throws BeansException, ClassNotFoundException;
	void loadBeanDefinitions(String... locations) throws BeansException;
}
