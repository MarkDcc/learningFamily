package cn.bugstack.springframework.aop.framwork;

import cn.bugstack.springframework.aop.AdvisedSupport;
import cn.bugstack.springframework.util.ClassUtils;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 11:35
 */
public class Cglib2AopProxy implements AopProxy{
	private AdvisedSupport advisedSupport;

	public Cglib2AopProxy(AdvisedSupport advisedSupport) {
		this.advisedSupport = advisedSupport;
	}

	@Override
	public Object getProxy() {
		Enhancer enhancer = new Enhancer();
		Class<?> aClass = advisedSupport.getTargetSource().getTarget().getClass();
		aClass = ClassUtils.isCglibProxyClass(aClass) ? aClass.getSuperclass():aClass;
		enhancer.setSuperclass(aClass);
		enhancer.setInterfaces(advisedSupport.getTargetSource().getTargetClass());
		enhancer.setCallback(new CglibMethodInterceptor(advisedSupport));

		return enhancer.create();
	}

	private  class CglibMethodInterceptor implements MethodInterceptor{

		private final AdvisedSupport advisedSupport;

		public CglibMethodInterceptor(AdvisedSupport advisedSupport) {
			this.advisedSupport = advisedSupport;
		}

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			CglibMethodInvocation cglibMethodInvocation =
					new CglibMethodInvocation(advisedSupport.getTargetSource().getTarget(),method,args,proxy);
			if(advisedSupport.getMethodMatcher().matches(method,advisedSupport.getTargetSource().getTarget().getClass())){
				return advisedSupport.getMethodInterceptor().invoke(cglibMethodInvocation);
			}
			return cglibMethodInvocation.proceed();
		}
	}

	private class CglibMethodInvocation extends ReflectiveMethodInvocation {

		private final MethodProxy methodProxy;


		public CglibMethodInvocation(Object target, Method method, Object[] arguments,MethodProxy methodProxy) {
			super(target, method, arguments);
			this.methodProxy = methodProxy;
		}

		@Override
		public Object proceed() throws Throwable {
			return methodProxy.invoke(target, arguments);
		}
	}
}
