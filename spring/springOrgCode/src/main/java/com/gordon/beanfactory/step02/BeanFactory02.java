package com.gordon.beanfactory.step02;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:21
 */
public interface BeanFactory02 {
	Object getBean(String beanName);
	Object getBean(String beanName,Object... args);
}
