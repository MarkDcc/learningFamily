package org.gordon.beans.factory.config;

import org.gordon.beans.factory.HierarchicalBeanFactory;

/**
 * @Author:dongchen
 * @Date: 2023/3/19 19:48
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry  {
	String SCOPE_SINGLETON = "singleton";

	String SCOPE_PROTOTYPE = "prototype";
}
