package org.gordon.context.support;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.ConfigurableListableBeanFactory;
import org.gordon.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author:dongchen
 * @Date: 2023/3/26 15:29
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{
	private DefaultListableBeanFactory beanFactory ;

	@Override
	protected void refreshBeanFactory() throws BeansException {
		DefaultListableBeanFactory beanFactory = createBeanFactory();
		loadBeanDefinition(beanFactory);
		this.beanFactory = beanFactory;
	}

	protected abstract void loadBeanDefinition(DefaultListableBeanFactory beanFactory) ;

	private DefaultListableBeanFactory createBeanFactory() {
		return new DefaultListableBeanFactory();
	}

	@Override
	protected ConfigurableListableBeanFactory getBeanFactory() {
		return beanFactory;
	}
}
