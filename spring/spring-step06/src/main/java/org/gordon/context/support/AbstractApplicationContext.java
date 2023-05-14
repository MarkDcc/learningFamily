package org.gordon.context.support;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.ConfigurableListableBeanFactory;
import org.gordon.beans.factory.config.BeanFactoryPostProcessor;
import org.gordon.beans.factory.config.BeanPostProcessor;
import org.gordon.context.ConfigurableApplicationContext;
import org.gordon.io.DefaultResourceLoader;

import java.util.Map;
import java.util.Set;

/**
 * @Author:dongchen
 * @Date: 2023/3/26 14:30
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

	protected abstract void refreshBeanFactory() throws BeansException;

	protected abstract ConfigurableListableBeanFactory getBeanFactory();

	@Override
	public Object getBean(String beanName) throws BeansException {
		return getBeanFactory().getBean(beanName);
	}

	@Override
	public Object getBean(String beanName, Object... args) throws BeansException {
		return getBeanFactory().getBean(beanName,args);
	}

	@Override
	public <T> T getBean(String beanName, Class<T> requiredType) throws BeansException {
		return getBeanFactory().getBean(beanName, requiredType);
	}

	@Override
	public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
		return getBeanFactory().getBeansOfType(type);
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return getBeanFactory().getBeanDefinitionNames();
	}

	@Override
	public void refresh() throws BeansException {
		// 1. 创建 BeanFactory，并加载 BeanDefinition
		refreshBeanFactory();

		// 2. 获取 BeanFactory
		ConfigurableListableBeanFactory beanFactory = getBeanFactory();

		// 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
		invokeBeanFactoryPostProcessors(beanFactory);

		// 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
		registerBeanPostProcessors(beanFactory);

	}

	private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
		for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
			beanFactory.addBeanPostProcessor(beanPostProcessor);
		}
	}

	private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
		Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
		for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
			beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
		}
	}
}
