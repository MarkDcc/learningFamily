package org.gordon.beans.factory;

/**
 * @Author:dongchen
 * @Date: 2023/4/9 15:29
 */
public interface BeanFactoryAware extends Aware{
	void setBeanFactory(BeanFactory beanFactory);
}
