package org.gordon.beans.factory.config;


import org.gordon.beans.PropertyValues;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 14:59
 */
public class BeanDefinition {
	public Class bean;
	private PropertyValues propertyValues;

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public BeanDefinition(Class bean) {
		this.bean = bean;
	}

	public Class getBeanClass() {
		return bean;
	}
}
