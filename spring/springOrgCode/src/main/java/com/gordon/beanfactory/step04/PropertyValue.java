package com.gordon.beanfactory.step04;

/**
 * @Author:dongchen
 * @Date: 2023/3/12 14:24
 */
public class PropertyValue {
	private final String name;
	private final Object value;

	public PropertyValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

}
