package org.gordon.beans.factory;

/**
 * @Author:dongchen
 * @Date: 2023/4/9 15:29
 */
public interface BeanNameAware extends Aware{
	void setBeanName(String beanName);
}
