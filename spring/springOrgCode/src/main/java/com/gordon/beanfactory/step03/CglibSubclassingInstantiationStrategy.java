package com.gordon.beanfactory.step03;

import com.gordon.beanfactory.step02.BeanDefinition02;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 16:49
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
	@Override
	public Object instantiate(BeanDefinition02 beanDefinition, String beanName, Constructor ctor, Object[] args) {
		/**
		 * TODO
		 * 未懂，待研究
		 */
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(beanDefinition.getBeanClass());
		enhancer.setCallback(new NoOp() {
			@Override
			public int hashCode() {
				return super.hashCode();
			}
		});
		if (null == ctor) return enhancer.create();
		return enhancer.create(ctor.getParameterTypes(), args);
	}
}
