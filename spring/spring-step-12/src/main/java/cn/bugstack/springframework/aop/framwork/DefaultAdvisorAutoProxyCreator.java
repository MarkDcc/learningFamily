package cn.bugstack.springframework.aop.framwork;

import cn.bugstack.springframework.aop.*;
import cn.bugstack.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.BeanFactoryAware;
import cn.bugstack.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 17:11
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

	private DefaultListableBeanFactory beanFactory;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		if (isInfrastructureClass(beanClass)) return null;
		Collection<AspectJExpressionPointcutAdvisor> aspectJExpressionAdvisor = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
		for (AspectJExpressionPointcutAdvisor advisor : aspectJExpressionAdvisor) {
			ClassFilter classFilter = advisor.getPointcut().getClassFilter();
			if (!classFilter.matches(beanClass)) continue;
			AdvisedSupport advisedSupport = new AdvisedSupport();
			try {
				advisedSupport.setTargetSource(new TargetSource(beanClass.getDeclaredConstructor().newInstance()));
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			}
			advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
			advisedSupport.setProxyTargetClass(false);
			advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
			return new ProxyFactory(advisedSupport).getProxy();
		}
		return null;
	}

	private boolean isInfrastructureClass(Class<?> beanClass) {
		return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = (DefaultListableBeanFactory) beanFactory;
	}
}
