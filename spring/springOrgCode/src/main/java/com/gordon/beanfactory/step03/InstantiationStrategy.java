package com.gordon.beanfactory.step03;

import com.gordon.beanfactory.step02.BeanDefinition02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 16:49
 */
public interface InstantiationStrategy {
	Object instantiate(BeanDefinition02 beanDefinition, String beanName, Constructor ctor, Object[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
