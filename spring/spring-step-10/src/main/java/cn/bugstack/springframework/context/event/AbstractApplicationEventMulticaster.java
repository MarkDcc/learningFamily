package cn.bugstack.springframework.context.event;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.BeanFactoryAware;
import cn.bugstack.springframework.context.ApplicationEvent;
import cn.bugstack.springframework.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.acl.Acl;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:dongchen
 * @Date: 2023/5/13 14:50
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

	private HashSet<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

	private BeanFactory beanFactory;

	@Override
	public void addApplicationListener(ApplicationListener<?> listener) {
		applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
	}

	@Override
	public void removeApplicationListener(ApplicationListener<?> listener) {
		applicationListeners.remove(listener);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	protected Collection<? extends ApplicationListener> getApplicationListener(ApplicationEvent event){
		Set<ApplicationListener<ApplicationEvent>> applicationListenersResult = new HashSet<>();
		for (ApplicationListener<ApplicationEvent> applicationListener : applicationListeners) {
			if(supportListener(applicationListener,event)){
				applicationListenersResult.add(applicationListener);
			}
		}
		return applicationListenersResult;
	}

	protected boolean supportListener(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
		/**
		 * 获取ApplicationListener<E extends ApplicationEvent>中E的具体类型，比较E与Event
		 */
		Class<? extends ApplicationListener> listenerClass = applicationListener.getClass();
		Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass)?
		listenerClass.getSuperclass() : listenerClass;
		Type genericInterface = targetClass.getGenericInterfaces()[0];
		Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
		String typeName = actualTypeArgument.getTypeName();
		Class<?> aClass;
		try {
			 aClass = Class.forName(typeName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		return aClass.isAssignableFrom(event.getClass());
	}

}
