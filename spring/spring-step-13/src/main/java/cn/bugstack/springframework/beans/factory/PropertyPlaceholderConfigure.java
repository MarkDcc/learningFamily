package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.PropertyValue;
import cn.bugstack.springframework.beans.PropertyValues;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.bugstack.springframework.core.io.DefaultResourceLoader;
import cn.bugstack.springframework.core.io.Resource;

import javax.sound.sampled.Port;
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
					String str = (String) value;
					StringBuffer buffer = new StringBuffer(str);
					int startI = buffer.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
					int endI = buffer.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
					if(startI != -1 && endI != -1 && endI>startI){
						String propertyKey = buffer.substring(startI+2, endI);
						buffer.replace(startI, endI+1, properties.getProperty(propertyKey));
						propertyValues.addPropertyValue(new PropertyValue(propertyKey,buffer.toString()));
					}
				}
			}

		} catch (IOException e) {
			throw new BeansException("Could not load properties",e);
		}

	}
}
