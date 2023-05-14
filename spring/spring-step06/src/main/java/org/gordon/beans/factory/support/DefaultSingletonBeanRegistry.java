package org.gordon.beans.factory.support;

import org.gordon.beans.factory.config.BeanDefinition;
import org.gordon.beans.factory.config.SingletonBeanRegistry;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/3/11 15:02
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	private Map<String ,Object> beanDefinitionMap = new HashMap<>();
	private Map<String,BeanDefinition> disposableBeans = new HashMap<>();

	public void addDisposableBeans(String beanName, BeanDefinition beanDefinition) {
		this.disposableBeans.put(beanName,beanDefinition);
	}


	@Override
	public Object getSingleton(String beanName) {
		return beanDefinitionMap.get(beanName);
	}

	@Override
	public void registerSingleton(String beanName, Object singletonObject) {
		beanDefinitionMap.put(beanName,singletonObject);
	}

	public void destroySingletons(){
		disposableBeans.forEach((beanName,beanDefinition)->{
			try {
				beanDefinition.getBeanClass().getMethod(beanDefinition.getDestroyDataMethod() ).invoke(getSingleton(beanName));
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			}
		});
	}

}
