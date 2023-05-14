package com.gordon.beanfactory.step02;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:21
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory02 {
	@Override
	public Object getBean(String beanName) {
		return doGetBean(beanName,null);
	}

	@Override
	public Object getBean(String beanName, Object... args) {
		return doGetBean(beanName,args);
	}

	private Object doGetBean(String beanName, Object... args) {
		Object singleton = getSingleton(beanName);
		if(singleton != null){
			return singleton;
		}
		BeanDefinition02 beanDefinition02 = getBeanDefinition02(beanName);
		return createBean(beanName, beanDefinition02,args);
	}

	abstract BeanDefinition02 getBeanDefinition02(String beanName);

	abstract Object createBean(String beanName,BeanDefinition02 beanDefinition02,Object... args);

}
