package com.gordon.beanfactory.step02;

import com.gordon.beanfactory.step04.PropertyValues;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 14:59
 */
public class BeanDefinition02 {
	public Class bean;
	private PropertyValues propertyValues;

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public BeanDefinition02(Class bean) {
		this.bean = bean;
	}

	public Class getBeanClass() {
		return bean;
	}
}
