package org.gordon.beans.factory;

/**
 * @Author:dongchen
 * @Date: 2023/4/9 15:27
 */
public interface BeanClassLoaderAware extends Aware{
	void setBeanClassLoader(ClassLoader classLoader);
}
