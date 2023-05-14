package org.gordon.io;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.gordon.beans.factory.support.BeanDefinitionRegistry;

/**
 * @Author:dongchen
 * @Date: 2023/3/25 17:23
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
	private BeanDefinitionRegistry registry;
	private ResourceLoader resourceLoader;

	public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
		this.registry = registry;
		this.resourceLoader = resourceLoader;
	}

	public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this(registry,new DefaultResourceLoader());
	}

	@Override
	public BeanDefinitionRegistry getRegistry() {
		return registry;
	}

	@Override
	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

	private Boolean containerRegistry(String beanName){
		return registry.containerBeanDefinition(beanName);
	}
}
