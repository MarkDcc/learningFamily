package org.gordon.context.support;

import org.gordon.beans.BeansException;
import org.gordon.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Author:dongchen
 * @Date: 2023/3/26 15:40
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
	private String[] configLocations;
	@Override
	protected String[] getConfigLocations() {
		return configLocations;
	}

	public ClassPathXmlApplicationContext(String[] configLocations) {
		this.configLocations = configLocations;
		refresh();
	}
	/**
	 * 从 XML 中加载 BeanDefinition，并刷新上下文
	 *
	 * @param configLocations
	 * @throws BeansException
	 */
	public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
		this(new String[]{configLocations});
	}
}
