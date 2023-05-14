package org.gordon.context.support;

import org.gordon.beans.factory.support.DefaultListableBeanFactory;
import org.gordon.io.XmlBeanDefinitionReader;

/**
 * @Author:dongchen
 * @Date: 2023/3/26 15:34
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
	//private XmlBeanDefinitionReader xmlBeanDefinitionReader;

	@Override
	protected void loadBeanDefinition(DefaultListableBeanFactory beanFactory)  {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
		String[] locations = getConfigLocations();
		xmlBeanDefinitionReader.loadBeanDefinitions(locations);
	}

	protected abstract String[] getConfigLocations();
}
