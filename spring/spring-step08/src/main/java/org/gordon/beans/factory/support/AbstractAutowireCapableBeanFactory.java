package org.gordon.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.gordon.beans.BeansException;
import org.gordon.beans.PropertyValue;
import org.gordon.beans.PropertyValues;
import org.gordon.beans.factory.Aware;
import org.gordon.beans.factory.BeanClassLoaderAware;
import org.gordon.beans.factory.BeanFactoryAware;
import org.gordon.beans.factory.BeanNameAware;
import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.BeanPostProcessor;
import org.gordon.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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

			// 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
			bean = initializeBean(beanName, bean, beanDefinition);
		} catch (InstantiationException | IllegalAccessException e) {
			throw new BeansException(e.getMessage());
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}

		registerSingleton(beanName,bean);
		registryDisposableBeansIfNecessary(beanName,beanDefinition);
		return bean;
	}

	private void registryDisposableBeansIfNecessary(String beanName, BeanDefinition beanDefinition){
		String destroyDataMethod = beanDefinition.getDestroyDataMethod();
		if(!destroyDataMethod.isEmpty()){
			addDisposableBeans(beanName,beanDefinition);
		}
	}

	private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
		//0. 执行aware操作
		if(bean instanceof Aware){
			if( bean instanceof BeanClassLoaderAware){
				((BeanClassLoaderAware) bean).setBeanClassLoader(getBeanClassLoader());
			}
			if(bean instanceof BeanFactoryAware){
				((BeanFactoryAware) bean).setBeanFactory(this);
			}
			if(bean instanceof BeanNameAware){
				((BeanNameAware) bean).setBeanName(beanName);
			}
		}

		// 1. 执行 BeanPostProcessor Before 处理
		Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

		// 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
		invokeInitMethods(beanName, wrappedBean, beanDefinition);

		// 2. 执行 BeanPostProcessor After 处理
		wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
		return wrappedBean;
	}

	private Object applyBeanPostProcessorsAfterInitialization(Object wrappedBean, String beanName) {
		List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
		Object result = wrappedBean;
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
			Object current = beanPostProcessor.postProcessAfterInitialization(wrappedBean,beanName);
			if(current == null) {
				return result;
			}
			result = current;
		}
		return result;
	}

	private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {
		String initMethod = beanDefinition.getInitMethod();
		if(!initMethod.isEmpty()){
			try {
				beanDefinition.getBeanClass().getMethod(initMethod).invoke(wrappedBean);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private Object applyBeanPostProcessorsBeforeInitialization(Object bean, String beanName) {
		List<BeanPostProcessor> beanPostProcessors = getBeanPostProcessors();
		Object result = bean;
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
			Object current = beanPostProcessor.postProcessBeforeInitialization(bean,beanName);
			if(current == null) {
				return result;
			}
			result = current;
		}
		return result;
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
