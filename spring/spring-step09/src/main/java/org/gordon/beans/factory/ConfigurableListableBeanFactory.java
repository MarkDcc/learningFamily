package org.gordon.beans.factory;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.config.AutowireCapableBeanFactory;
import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.ConfigurableBeanFactory;

/**
 * @Author:dongchen
 * @Date: 2023/3/19 19:52
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory {
	BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
