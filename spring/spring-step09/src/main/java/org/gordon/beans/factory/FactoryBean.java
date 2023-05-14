package org.gordon.beans.factory;

/**
 * @Author:dongchen
 * @Date: 2023/5/12 19:50
 */
public interface FactoryBean<T> {
	T getObject();

	Class<?> getObjectType();

	boolean isSingleton();
}
