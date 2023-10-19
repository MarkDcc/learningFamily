package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 17:06
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
	Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
