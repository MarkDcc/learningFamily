package org.gordon.beans.factory.support;

import org.gordon.beans.factory.FactoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/5/12 19:53
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry{


	private Map<String, Object> factoryBeanObjectCache = new HashMap<>();

	protected Object getCachedObjectForFactoryBean(String beanName){
		Object bean = factoryBeanObjectCache.get(beanName);
		if(NULL_OBJECT != bean){
			return bean;
		}
		return null;
	}

	protected Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName){
//		if(factoryBean == null){
//			Object beanObject = doGetObjectFromFactoryBean(factoryBean, beanName);
//			factoryBeanObjectCache.put(beanName,beanObject);
//			return beanObject;
//		}
		if(factoryBean.isSingleton()){
			Object bean = factoryBeanObjectCache.get(beanName);
			if(bean == null){
				Object beanObject = doGetObjectFromFactoryBean(factoryBean, beanName);
				factoryBeanObjectCache.put(beanName,beanObject);
			}
			return NULL_OBJECT != bean ? bean : null;
		}
		return  doGetObjectFromFactoryBean(factoryBean,beanName);
	}

	private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName){
		Object beanObject = factoryBean.getObject();
		return beanObject;
	}

}
