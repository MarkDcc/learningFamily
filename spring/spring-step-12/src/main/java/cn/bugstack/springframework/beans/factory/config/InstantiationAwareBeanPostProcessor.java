package cn.bugstack.springframework.beans.factory.config;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 17:06
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {


	Object postProcessBeforeInitialization(Class<?> beanClass, String beanName) throws BeansException;
}
