package com.gordon.beanfactory.step04;

/**
 * @Author:dongchen
 * @Date: 2023/3/12 14:23
 */
public class BeanReference {
	private String beanName;

	public BeanReference(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanName() {
		return beanName;
	}
}
