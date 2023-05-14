package com.gordon.beanfactory;

import com.gordon.beanfactory.step04.PropertyValues;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 13:46
 */
public class BeanDefinition {
	public Class bean;
	public PropertyValues propertyValues;

	public BeanDefinition(Class bean) {
		this.bean = bean;
	}

	public BeanDefinition(Class bean, PropertyValues propertyValues) {
		this.bean = bean;
		this.propertyValues = propertyValues;
	}

	public Class getBean() {
		return bean;
	}
}
