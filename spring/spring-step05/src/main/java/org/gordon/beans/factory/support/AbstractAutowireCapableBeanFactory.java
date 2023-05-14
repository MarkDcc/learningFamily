package org.gordon.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.gordon.beans.BeansException;
import org.gordon.beans.PropertyValue;
import org.gordon.beans.PropertyValues;
import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:27
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

	private InstantiationStrategy instantiationStrategy;

	@Override
	Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) {
		Object bean = null;
		try {
			Constructor useConstructor = null;

			Constructor[] constructors = beanDefinition.getBeanClass().getConstructors();
			for (Constructor constructor : constructors) {
				if(args == null){
					useConstructor = null;
					break;
				}
				//TODO 比较构造器参数个数
				if(constructor.getParameterCount()==args.length&& constructor.getParameterTypes().length==args.length){
					//TODO 比较构造器参数类型
					if(constructor.getParameterTypes()[0].getClass().isInstance(String.class)){
						useConstructor = constructor;
					}

				}
			}

			bean = createBeanStrategy(beanName,beanDefinition,useConstructor,args);
			applyPropertyValues(beanName,bean,beanDefinition);

		} catch (InstantiationException | IllegalAccessException e) {
			throw new BeansException(e.getMessage());
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}

		registerSingleton(beanName,bean);
		return bean;
	}

	private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
		//填充属性
		PropertyValues propertyValues = beanDefinition.getPropertyValues();
		if(propertyValues == null){
			return;
		}
		for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
			String name = propertyValue.getName();
			Object value = propertyValue.getValue();
			if(value instanceof BeanReference){
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getBeanName());
			}
			BeanUtil.setFieldValue(bean,name,value);
		}
	}

	private Object createBeanStrategy(String beanName, BeanDefinition beanDefinition, Constructor cotr,Object... args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		setInstantiationStrategy(new CglibSubclassingInstantiationStrategy());
		return getInstantiationStrategy().instantiate(beanDefinition, beanName, cotr, args);
		//return beanDefinition02.getBeanClass().newInstance();
	}

	public InstantiationStrategy getInstantiationStrategy() {
		return instantiationStrategy;
	}

	public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
		this.instantiationStrategy = instantiationStrategy;
		//this.instantiationStrategy = new CglibSubclassingInstantiationStrategy();
	}
}
