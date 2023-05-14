package org.gordon.context;

import org.gordon.beans.BeansException;

/**
 * @Author:dongchen
 * @Date: 2023/3/26 14:27
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
	/**
	 * 刷新容器
	 *
	 * @throws BeansException
	 */
	void refresh() throws BeansException;

	void destroy();
}
