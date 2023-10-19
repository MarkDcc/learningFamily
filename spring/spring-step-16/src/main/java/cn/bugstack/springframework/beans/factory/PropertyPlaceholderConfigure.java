package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.bugstack.springframework.core.io.DefaultResourceLoader;
import cn.bugstack.springframework.core.io.Resource;
import cn.bugstack.springframework.util.StringValueResolver;

import javax.sound.sampled.Port;
import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author:dongchen
 * @Date: 2023/5/28 16:34
 */
public class PropertyPlaceholderConfigure implements BeanFactoryPostProcessor {
	/**
	 * Default placeholder prefix: {@value}
	 */
	public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

	/**
	 * Default placeholder suffix: {@value}
	 */
	public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";
	private String location;

	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource(location);
		try {
			Properties properties = new Properties();
			properties.load(resource.getInputStream());
			String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
			for (String beanName : beanDefinitionNames) {
				BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
				PropertyValues propertyValues = beanDefinition.getPropertyValues();
				for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
					Object value = propertyValue.getValue();
					if(!(value instanceof String)) continue;
					value = resolvePlaceHolder(properties, (String) value);
					propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(),value));
				}
			}
			PlaceholderResolvingStringValueResolver stringValueResolver = new PlaceholderResolvingStringValueResolver(properties);
			beanFactory.addEmbeddedValueResolver(stringValueResolver);
		} catch (IOException e) {
			throw new BeansException("Could not load properties",e);
		}

	}

	private static String resolvePlaceHolder(Properties properties, String str) {
		StringBuffer buffer = new StringBuffer(str);
		int startI = buffer.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
		int endI = buffer.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
		if(startI != -1 && endI != -1 && endI>startI){
			String propertyKey = buffer.substring(startI+2, endI);
			String propertyValue = properties.getProperty(propertyKey);
			buffer.replace(startI, endI+1, propertyValue);
		}
		return buffer.toString();
	}

	private class PlaceholderResolvingStringValueResolver implements StringValueResolver{
		private final Properties properties;

		public PlaceholderResolvingStringValueResolver(Properties properties) {
			this.properties = properties;
		}

		@Override
		public String resolveStringValue(String strVal) {
			return PropertyPlaceholderConfigure.resolvePlaceHolder(properties, strVal);
		}
	}
}

