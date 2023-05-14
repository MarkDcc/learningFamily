package cn.bugstack.springframework.aop;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.BeanFactoryAware;
import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 11:33
 */
public class AdvisedSupport {

	private TargetSource targetSource;
	private MethodMatcher methodMatcher;

	// 方法拦截器
	private MethodInterceptor methodInterceptor;

	public TargetSource getTargetSource() {
		return targetSource;
	}

	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}

	public MethodMatcher getMethodMatcher() {
		return methodMatcher;
	}

	public void setMethodMatcher(MethodMatcher methodMatcher) {
		this.methodMatcher = methodMatcher;
	}

	public MethodInterceptor getMethodInterceptor() {
		return methodInterceptor;
	}

	public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
		this.methodInterceptor = methodInterceptor;
	}

	/**
	 * @Author:dongchen
	 * @Date: 2023/5/14 17:11
	 */
	public static class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

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
		public Object postProcessBeforeInitialization(Class<?> beanClass, String beanName) throws BeansException {
			if (isInfrastructureClass(beanClass)) return null;
			Collection<AspectJExpressionPointcutAdvisor> aspectJExpressionAdvisor = beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
			for (AspectJExpressionPointcutAdvisor advisor : aspectJExpressionAdvisor) {
				ClassFilter classFilter = advisor.getPointcut().getClassFilter();
				if (!classFilter.matches(beanClass)) continue;

				return null;
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
}
